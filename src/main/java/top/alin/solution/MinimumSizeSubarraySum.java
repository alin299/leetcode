package top.alin.solution;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = nums.length + 1;
        for(int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans > nums.length ? 0 : ans;
    }
}
