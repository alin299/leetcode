package top.alin.solution;

public class LogicalOrOfTwoBinaryGridsRepresentedAsQuadTree {
    public Node intersect(Node n1, Node n2) {
        if (n1.isLeaf) {
            if (n1.val) {
                return n1;
            } else {
                return n2;
            }
        }
        if (n2.isLeaf) {
            return dfs(n2, n1);
        }

        Node o1 = dfs(n1.topLeft, n2.topLeft);
        Node o2 = dfs(n1.topRight, n2.topRight);
        Node o3 = dfs(n1.bottomLeft, n2.bottomLeft);
        Node o4 = dfs(n1.bottomRight, n2.bottomRight);

        if (o1.isLeaf && o2.isLeaf && o3.isLeaf && o4.isLeaf && o1.val == o2.val && o1.val == o3.val && o1.val == o4.val) {
            return new Node(o1.val, true);
        }
        return new Node(false, false, o1, o2, o3, o4);
    }

    Node dfs(Node n1, Node n2) {
        if (n1.isLeaf) {
            if (n1.val) {
                return n1;
            } else {
                return n2;
            }
        }
        if (n2.isLeaf) {
            return dfs(n2, n1);
        }

        Node root = new Node();
        Node o1 = dfs(n1.topLeft, n2.topLeft);
        Node o2 = dfs(n1.topRight, n2.topRight);
        Node o3 = dfs(n1.bottomLeft, n2.bottomLeft);
        Node o4 = dfs(n1.bottomRight, n2.bottomRight);

        if (o1.isLeaf && o2.isLeaf && o3.isLeaf && o4.isLeaf && o1.val == o2.val && o1.val == o3.val && o1.val == o4.val) {
            return new Node(o1.val, true);
        }
        return new Node(false, false, o1, o2, o3, o4);
    }
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf) {
            val = _val;
            isLeaf = _isLeaf;
        }

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
}
