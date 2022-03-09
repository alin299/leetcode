package top.alin.solution;

public class MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 0, first = -1;
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                ++pos;
            } else if (nums[i] == 0) {
                pos = 0;
                neg = 0;
                first = -1;
            } else {
                ++neg;
                first = first == -1 ? i : first;
            }
            if (neg % 2 == 0) {
                ans = Math.max(ans, pos + neg);
            } else {
                ans = Math.max(ans, i - first);
            }
        }
        return ans;
    }
}
