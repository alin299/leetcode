package top.alin.solution;

public class RangeModule {
    Node root;
    final int N = (int)1e9;

    public RangeModule() {
        root = new Node();
    }

    public void addRange(int left, int right) {
        update(root, 1, N, left, right - 1, true);
    }

    public boolean queryRange(int left, int right) {
        return query(root, 1, N, left, right - 1);
    }

    public void removeRange(int left, int right) {
        update(root, 1, N, left, right - 1, false);
    }

    static class Node {
        Node left, right;
        boolean val, modified;
        public Node() {
            val = modified = false;
        }
    }

    public void update(Node node, int start, int end, int left, int right, boolean val) {
        if (left <= start && end <= right) {
            node.modified = true;
            node.val = val;
            return;
        }
        pushDown(node);

        int mid = start + (end - start) / 2;
        if (left <= mid) update(node.left, start, mid, left, right, val);
        if (right > mid) update(node.right, mid + 1, end, left, right, val);

        pushUp(node);
    }

    public boolean query(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return node.val;
        }
        pushDown(node);

        boolean ans = true;
        int mid = start + (end - start) / 2;
        if (left <= mid) ans = ans && query(node.left, start, mid, left, right);
        if (right > mid) ans = ans && query(node.right, mid + 1, end, left, right);

        return ans;
    }

    public void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (!node.modified) return;
        node.left.val = node.right.val = node.val;
        node.left.modified = node.right.modified = true;
        node.modified = false;
    }

    public void pushUp(Node node) {
        node.val = node.left.val && node.right.val;
    }
}
