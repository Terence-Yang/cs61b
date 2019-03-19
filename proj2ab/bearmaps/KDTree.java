package bearmaps;

import java.util.List;

public class KDTree implements PointSet {
    private static final boolean HORIZONTAL = false;
    private static final boolean VERTICAL = true;
    private Node root;

    private class Node {
        private Point p;
        private boolean orientation;
        private Node leftBottom;
        private Node rightTop;

        Node(Point p, boolean orientation) {
            this.p = p;
            this.orientation = orientation;
        }
    }

    public KDTree(List<Point> points) {
        for (Point p : points) {
            root = add(p, root, HORIZONTAL);
        }
    }

    private Node add(Point p, Node n, boolean orientation) {
        if (n == null) {
            return new Node(p, orientation);
        }
        if (p.equals(n.p)) {
            return n;
        }

        int cmp = comparePoints(p, n.p, orientation);
        if (cmp < 0) {
            n.leftBottom = add(p, n.leftBottom, !orientation);
        } else if (cmp >= 0) {
            n.rightTop = add(p, n.rightTop, !orientation);
        }
        return n;
    }

    private int comparePoints(Point a, Point b, boolean orientation) {
        if (orientation == HORIZONTAL) {
            return Double.compare(a.getX(), b.getX());
        } else {
            return Double.compare(a.getY(), b.getY());
        }
    }

    @Override
    public Point nearest(double x, double y) {
        return null;
    }

    private static void buildLectureTree() {
        Point p1 = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(4, 2);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(4, 5);
        Point p5 = new Point(3, 3);
        Point p6 = new Point(1, 5);
        Point p7 = new Point(4, 4);

        KDTree kd = new KDTree(List.of(p1, p2, p3, p4, p5, p6, p7));
    }

    private static void buildTreesWithDoubles() {
        Point p1 = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(2, 3);

        KDTree kd = new KDTree(List.of(p1, p2));
    }

    public static void main(String[] args) {
        buildTreesWithDoubles();
    }
}
