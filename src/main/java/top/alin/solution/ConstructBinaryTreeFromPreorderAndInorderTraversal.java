package top.alin.solution;

import top.alin.common.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    TreeNode buildTree(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if (e1 == s1) {
            return null;
        }
        int rootIndex = s2;
        for (int i = s2; i < e2; i++) {
            if (inorder[i] == preorder[s1]) {
                rootIndex = i;
                break;
            }
        }
        int leftNum = rootIndex - s2;
        TreeNode root = new TreeNode(preorder[s1]);
        root.left = buildTree(preorder, inorder, s1 + 1, s1 + leftNum + 1, s2, rootIndex);
        root.right = buildTree(preorder, inorder, s1 + leftNum + 1, e1, rootIndex + 1, e2);
        return root;
    }
}
