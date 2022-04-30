package top.alin.solution;

import java.util.Arrays;

public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length;
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = max - min - 2 * k;
        return ans > 0 ? ans : 0;
    }
}
