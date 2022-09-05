package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateSubtrees {
    Set<String> keys;
    List<TreeNode> ans;
    Set<String> trees;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        keys = new HashSet<>();
        trees = new HashSet<>();
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuffer tree = new StringBuffer();
        tree.append(root.val).append('-').append(dfs(root.left)).append('-').append(dfs(root.right));
        String str = tree.toString();
        if (!trees.add(str) && keys.add(str)) {
            ans.add(root);
        }
        return str;
    }
}
