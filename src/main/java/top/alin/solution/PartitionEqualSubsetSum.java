package top.alin.solution;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums.length < 2) {
            return false;
        }
        int n = nums.length;
        int sum = 0, maxNum = 0;
        for(int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        if(maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 0; i < n; ++i) {
            int num = nums[i];
            for(int j = target;  j >= num; --j) {
                dp[j] = dp[j] | dp[j - num];
            }
        }
        return dp[target];
    }
}
