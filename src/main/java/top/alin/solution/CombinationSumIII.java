package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    List<List<Integer>> ans;
    List<Integer> curr;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        curr = new ArrayList<>();
        dfs(k, n, 1, 0);
        return ans;
    }

    void dfs(int k, int n, int start, int sum) {
        if (curr.size() == k && sum == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < 10; ++i) {
            if (sum + i > n) {
                break;
            }
            curr.add(i);
            dfs(k, n, i + 1, sum + i);
            curr.remove(curr.size() - 1);
        }
    }
}
