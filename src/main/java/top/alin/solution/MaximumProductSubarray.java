package top.alin.solution;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int ans = nums[0];
        int dpMax = nums[0], dpMin = nums[0];
        for(int i = 1; i < n; ++i) {
            int preMax = dpMax;
            int preMin =dpMin;
            dpMax = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            dpMin = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i]));
            ans = Math.max(ans, dpMax);
        }
        return ans;
    }
}
