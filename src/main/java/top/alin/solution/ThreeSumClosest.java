package top.alin.solution;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) {continue;}
            int left = i + 1;
            int right = n - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) {
                    return target;
                }
                if(Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if(sum > target) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return closest;
    }
}
