package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSumII {
    List<List<Integer>> ans;
    Deque<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        path = new ArrayDeque<>();
        dfs(root, targetSum);
        return ans;
    }

    void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offer(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();

    }
}
