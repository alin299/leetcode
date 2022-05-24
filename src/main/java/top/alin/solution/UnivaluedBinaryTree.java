package top.alin.solution;

import top.alin.common.TreeNode;

public class UnivaluedBinaryTree {
    int val = -1;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (val == -1) {
            val = root.val;
        }
        return root.val == val && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
