package top.alin.solution;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i = 0; i < n; ++i) {
            int min = nums[i];
            int max = nums[i];
            for(int j = i + 1; j < n; ++j) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                ans += (max - min);
            }
        }
        return ans;
    }
}
