package top.alin.solution;

import top.alin.common.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        if((root.left = pruneTree(root.left)) == null & (root.right = pruneTree(root.right)) == null && root.val == 0) {
            return null;
        }

        return root;
    }
}
