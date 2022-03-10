package top.alin.solution;

import top.alin.common.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
    List<Integer> ans;
    public List<Integer> preorder(Node root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node child : root.children) {
            dfs(child);
        }
    }
}
