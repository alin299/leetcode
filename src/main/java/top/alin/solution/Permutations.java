package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(new ArrayList<>(), nums);
        return ans;
    }

    void dfs(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 11) {
                continue;
            }
            int num = nums[i];
            curr.add(num);
            nums[i] = 11;
            dfs(curr, nums);
            curr.remove(curr.size() - 1);
            nums[i] = num;
        }
    }
}
