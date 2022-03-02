package top.alin.solution;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        int[] nums2 = new int[max + 1];
        for(int num : nums) {
            nums2[num] += num;
        }
        return rob(nums2);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
