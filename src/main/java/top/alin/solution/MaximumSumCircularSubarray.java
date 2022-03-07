package top.alin.solution;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int preMax = 0, preMin = 0, maxVal = nums[0], minVal = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            preMin = Math.min(preMin + nums[i], nums[i]);
            minVal = Math.min(preMin, minVal);
            preMax = Math.max(preMax + nums[i], nums[i]);
            maxVal = Math.max(preMax, maxVal);
            sum += nums[i];
        }

        return Math.max(maxVal, sum - minVal == 0 ? maxVal : sum - minVal);
    }
}
