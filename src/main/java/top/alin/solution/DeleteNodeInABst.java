package top.alin.solution;

import top.alin.common.TreeNode;

public class DeleteNodeInABst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = root.right;
            while(node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            root = root.right;
        }
        return root;
    }
}
