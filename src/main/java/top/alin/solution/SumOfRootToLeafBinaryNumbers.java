package top.alin.solution;

import top.alin.common.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1) | root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
}
