package top.alin.solution;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ans = 0;
        for(int num : nums) {
            ans += Math.abs(num - mid);
        }
        return ans;
    }
}
