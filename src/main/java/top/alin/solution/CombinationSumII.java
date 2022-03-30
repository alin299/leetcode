package top.alin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> ans;
    List<Integer> curr;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return ans;
    }

    void dfs(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (sum + candidates[i] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curr.add(candidates[i]);
            dfs(candidates, target, i + 1, sum + candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
