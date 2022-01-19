package top.alin.solution;

import java.util.Arrays;

/**
 * find-first-and-last-position-of-element-in-sorted-array
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        ans[0] = binarySearchLeft(nums, target);
        if (ans[0] == -1) {
            return ans;
        }
        ans[1] = binarySearchRight(nums, target);
        return ans;
    }

    public int binarySearchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[right] == target ? right : -1;
    }
    public int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

}
