package top.alin.solution;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = k - 1; i < nums.length; ++i) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }
}
