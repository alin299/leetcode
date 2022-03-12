package top.alin.solution;

import top.alin.common.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for(Node child : root.children) {
                dfs(child);
            }
        }
        ans.add(root.val);
    }
}
