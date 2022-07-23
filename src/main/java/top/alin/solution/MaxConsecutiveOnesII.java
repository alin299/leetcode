package top.alin.solution;

public class MaxConsecutiveOnesII {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int count = 0;
            int n = nums.length;
            int ans = 1;
            for(int left = 0, right = 0; right < n; right++) {
                count += (nums[right] == 0 ? 1 : 0);
                while(count > 1) {
                    count -= (nums[left++] == 0 ? 1 : 0);
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
}
