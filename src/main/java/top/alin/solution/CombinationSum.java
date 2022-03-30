package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans;
    List<Integer> curr;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        curr = new ArrayList<>();
        dfs(candidates, target, 0, 0);
        return ans;
    }

    void dfs(int[] candidates, int target, int start, int sum) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            curr.add(candidates[i]);
            dfs(candidates, target, i, sum + candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
