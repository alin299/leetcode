package top.alin.solution;


import top.alin.common.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long lower, long upper) {
        if(root == null) {
            return true;
        }
        if(root.val <= lower || root.val >= upper ) {
            return false;
        }

        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }
}
