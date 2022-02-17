package top.alin.solution;

import top.alin.common.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[]{0, 0};
        }

        int[] lv = dfs(node.left);
        int[] rv = dfs(node.right);

        int f = node.val + lv[1] + rv[1];
        int g = Math.max(lv[0], lv[1]) + Math.max(rv[0], rv[1]);

        return new int[]{f, g};
    }
}
