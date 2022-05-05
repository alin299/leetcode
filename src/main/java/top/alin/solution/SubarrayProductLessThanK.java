package top.alin.solution;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int prod = 1;
        int ans = 0;
        for(int left = 0, right = 0; right < n; right++) {
            prod *= nums[right];
            while(left <= right && prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
