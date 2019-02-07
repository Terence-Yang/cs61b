public class LinkedListDeque<Item> {
    private Node sentinel;
    private int size;

    private class Node {
        Node prev;
        Item item;
        Node next;

        Node(Node p, Item i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Creates a deep copy of other. */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i++) {
            addLast((Item) other.get(i));
        }
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(Item item) {
        Node node = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(Item item) {
        Node node = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque.
     *  Must take constant time.
     */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     *  Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        Node curr = sentinel.next;
        while (curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null.
     */
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Item first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return first;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.
     */
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Item last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return last;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null.
     *  Must not alter the deque and must use iteration.
     */
    public Item get(int index) {
        if (index > size) {
            return null;
        }
        Node curr = sentinel.next;
        while (index > 0) {
            curr = curr.next;
            index -= 1;
        }
        return curr.item;
    }

    /** Same as get, but uses recursion. */
    public Item getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    private Item getRecursiveHelper(Node curr, int index) {
        if (index == 0) {
            return curr.item;
        } else {
            curr = curr.next;
            return getRecursiveHelper(curr, index - 1);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> deck = new LinkedListDeque<>();
        deck.addLast(0);
        deck.addLast(1);
        deck.addLast(2);
        deck.printDeque();
        System.out.println(deck.get(0));
        System.out.println(deck.getRecursive(2));
        System.out.println(deck.getRecursive(0));
//        System.out.println(deck.size());
//        LinkedListDeque<Integer> deck_clone = new LinkedListDeque<>(deck);
//        deck_clone.printDeque();
    }
}
