package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    Map<Long, Integer> map;
    int ans;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, targetSum, 0);
        return ans;
    }

    void dfs(TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        ans += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        map.put(sum, map.get(sum) - 1);
    }
}
