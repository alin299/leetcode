package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        dfs(0, root);
        return ans;
    }

    void dfs(int level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(node.val);
        }
        level++;
        dfs(level, node.right);
        dfs(level, node.left);
    }
}
