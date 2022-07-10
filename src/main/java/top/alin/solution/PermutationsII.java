package top.alin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), 0);
        return ans;
    }

    void dfs(int[] nums, boolean[] visited, List<Integer> cur, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            cur.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, cur, idx + 1);
            visited[i] = false;
            cur.remove(idx);
        }

    }
}
