package top.alin.solution;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public boolean[]  used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        if (sum % k != 0 || nums[nums.length - 1] > sum / k) return false;
        used = new boolean[nums.length];
        return dfs(nums, nums.length - 1, sum / k, 0, k);

    }

    public boolean dfs(int[] nums, int start, int target, int cur, int k) {
        if (k == 1) return true;
        if (cur == target) return dfs(nums, nums.length - 1, target, 0, k - 1);
        for (int i = start; i >= 0; i--) {
            if (used[i] || cur + nums[i] > target) continue;
            used[i] = true;
            if (dfs(nums, i - 1, target, cur + nums[i], k)) return true;
            used[i] = false;
            while (i > 0 && nums[i - 1] == nums[i]) i--;
        }
        return false;
    }
}
