package top.alin.solution;

import top.alin.common.TreeNode;

public class ConstructStringFromBinaryTree {
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        dfs(root);
        return sb.substring(1, sb.length()- 1);
    }

    public void dfs(TreeNode node) {
        sb.append('(');
        sb.append(node.val);
        if (node.left != null) {
            dfs(node.left);
        } else if (node.right != null) {
            sb.append("()");
        }

        if (node.right != null) {
            dfs(node.right);
        }
        sb.append(')');
    }
}
