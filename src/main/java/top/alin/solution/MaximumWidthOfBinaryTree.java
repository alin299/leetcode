package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    Map<Integer, Integer> map;
    int ans;
    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 1, 0);
        return ans;
    }

    void dfs(TreeNode root, int i, int depth) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, i);
        }
        ans = Math.max(ans, i - map.get(depth) + 1);
        dfs(root.left, i * 2, depth + 1);
        dfs(root.right, i * 2 + 1, depth + 1);
    }
}
