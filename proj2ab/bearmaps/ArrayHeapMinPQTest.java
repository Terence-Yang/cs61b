package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayHeapMinPQTest {

    @Test
    public void testAdd() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("C", 3);
        pq.add("A", 1);
        pq.add("B", 2);
        assertEquals(3, pq.size());
    }

    @Test
    public void testGetSmallest() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("B", 2);
        pq.add("C", 3);
        pq.add("A", 1);
        assertEquals("A", pq.getSmallest());
    }

    @Test
    public void testRemoveSmallest() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("A", 1);
        pq.add("C", 3);
        pq.add("B", 2);
        String s = pq.removeSmallest();
        assertEquals("A", s);
        assertEquals(2, pq.size());
    }

    @Test
    public void testChangePriority() {
        ArrayHeapMinPQ<String> pq = new ArrayHeapMinPQ<>();
        pq.add("A", 1);
        pq.add("C", 3);
        pq.add("B", 2);
        pq.changePriority("A", 5);
        pq.changePriority("C", 1);
        assertEquals("C", pq.getSmallest());
    }
}
