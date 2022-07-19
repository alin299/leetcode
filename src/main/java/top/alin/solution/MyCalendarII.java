package top.alin.solution;

public class MyCalendarII {
    public boolean book(int start, int end) {
        if (query(root, 0, N, start, end - 1) >= 2) return false;
        update(root, 0, N, start, end - 1, 1);
        return true;
    }

    int query(Node node, int l, int r, int start, int end) {
        if (start <= l && r <= end) {
            return node.val;
        }
        pushDown(node);
        int mid = (l + r) >> 1;
        int ans = 0;
        if (start <= mid) ans = query(node.left, l, mid, start, end);
        if (end > mid) ans = Math.max(ans, query(node.right, mid + 1, r, start, end));
        return ans;
    }

    void update(Node node, int l, int r, int start, int end, int val) {
        if (start <= l && r <= end) {
            node.add += val;
            node.val += val;
            return;
        }
        pushDown(node);
        int mid = (l + r) >> 1;
        if (start <= mid) update(node.left, l, mid, start, end, val);
        if (end > mid) update(node.right, mid + 1, r, start, end, val);
        pushUp(node);
    }

    void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.val == 0) return;
        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    void pushUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    private int N = (int)1e9;
    private Node root = new Node();

    private class Node {
        Node left;
        Node right;
        int val;
        int add;

    }
}
