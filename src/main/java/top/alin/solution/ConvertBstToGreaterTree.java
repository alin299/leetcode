package top.alin.solution;

import top.alin.common.TreeNode;

public class ConvertBstToGreaterTree {
    int pre;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        pre += root.val;
        root.val = pre;
        dfs(root.left);
    }
}
