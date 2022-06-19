package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    Map<Integer, Integer> map;
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = dfs(root.left) + dfs(root.right) + root.val;
        int count = map.getOrDefault(val, 0) + 1;
        map.put(val, count);
        max = Math.max(max, count);

        return val;
    }
}
