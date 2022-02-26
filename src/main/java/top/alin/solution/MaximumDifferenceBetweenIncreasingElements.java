package top.alin.solution;

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ans = 0;
        for(int i = 1; i < nums.length; ++i) {
            ans = Math.max(ans, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return ans == 0 ? -1 : ans;
    }
}
