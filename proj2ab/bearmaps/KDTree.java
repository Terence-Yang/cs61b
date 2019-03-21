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
        return nearest(root, new Point(x, y), root.p);
    }

    private Point nearest(Node n, Point target, Point best) {
        if (n == null) {
            return best;
        }
        if (Point.distance(n.p, target) < Point.distance(best, target)) {
            best = n.p;
        }
        best = nearest(n.leftBottom, target, best);
        best = nearest(n.rightTop, target, best);
        return best;
    }

    public static void main(String[] args) {

    }
}
