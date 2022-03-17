package top.alin.solution;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}
