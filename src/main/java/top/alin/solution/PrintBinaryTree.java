package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    int h;
    public List<List<String>> printTree(TreeNode root) {
        getHeight(root, 0);
        int m = h + 1;
        int n = (1 << (h + 1)) - 1;
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                row.add("");
            }
            list.add(row);
        }
        dfs(list, root, 0, (n - 1) / 2);
        return list;
    }

    void getHeight(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        h = Math.max(h, depth);
        getHeight(root.left, depth + 1);
        getHeight(root.right, depth + 1);
    }

    public void dfs(List<List<String>> list, TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        list.get(row).set(col, String.valueOf(root.val));
        dfs(list, root.left, row + 1, col - (1 << (h - row - 1)));
        dfs(list, root.right, row + 1, col + (1 << (h - row - 1)));
    }
}
