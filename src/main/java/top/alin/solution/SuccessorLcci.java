package top.alin.solution;

import top.alin.common.TreeNode;

public class SuccessorLcci {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        }
    }
}
