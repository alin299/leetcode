package top.alin.solution;

import top.alin.common.TreeNode;

public class BinaryTreeMaximumPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        int sum = root.val + left + right;
        max = Math.max(max, sum);

        return root.val + Math.max(left, right);
    }
}
