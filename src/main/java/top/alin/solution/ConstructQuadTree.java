package top.alin.solution;

public class ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

    }
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    Node dfs(int[][] grid, int x0, int y0, int x1, int y1) {
        boolean flag = true;
        for(int i = x0; i <= x1 && flag; i++) {
            for(int j = y0; j <= y1; j++) {
                if (grid[i][j] != grid[x0][y0]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            return new Node(grid[x0][y0] == 1, true);
        }
        int midX = x0 + (x1 - x0) / 2;
        int midY = y0 + (y1 - y0) / 2;
        Node tl = dfs(grid, x0, y0, midX, midY);
        Node tr = dfs(grid, x0, midY + 1, midX, y1);
        Node bl = dfs(grid, midX + 1, y0, x1, midY);
        Node br = dfs(grid, midX + 1, midY + 1, x1, y1);
        return new Node(grid[x0][y0] == 1, false, tl, tr, bl, br);
    }
}
