package top.alin.solution;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int dp = 0, ans = nums[0];
        for(int i = 0; i < nums.length; ++i) {
            if (dp <= 0) {
                dp = nums[i];
            } else {
                dp += nums[i];
            }
            ans = Math.max(ans, dp);
        }
        return ans;
    }
}
