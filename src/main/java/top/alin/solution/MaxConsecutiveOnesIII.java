package top.alin.solution;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        for (int  left = 0, right = 0; right < nums.length; ++right) {
            sum += nums[right] == 1 ? 0 : 1;
            while(sum > k) {
                sum -= nums[left++] == 1 ? 0 : 1;
            }
            cnt = Math.max(cnt, right - left + 1);
        }
        return cnt;
    }
}
