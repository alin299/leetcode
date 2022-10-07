package top.alin.solution;

public class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n;) {
            int sum = nums[i++];
            while(i < n && nums[i - 1] < nums[i]) {
                sum += nums[i++];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
