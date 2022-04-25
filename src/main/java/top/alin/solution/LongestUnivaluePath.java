package top.alin.solution;

import top.alin.common.TreeNode;

public class LongestUnivaluePath {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
