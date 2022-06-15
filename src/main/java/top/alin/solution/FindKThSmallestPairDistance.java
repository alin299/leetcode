package top.alin.solution;

import java.util.Arrays;

public class FindKThSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int i = 0, j = 0; j < n; j++) {
                while(nums[j] - nums[i] > mid) {
                    i++;
                }
                count += j - i;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
