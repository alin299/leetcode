package top.alin.solution;

import top.alin.common.TreeNode;

public class FindBottomLeftTreeValue {
    int ans;
    int depth;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > this.depth) {
            ans = root.val;
            this.depth = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
