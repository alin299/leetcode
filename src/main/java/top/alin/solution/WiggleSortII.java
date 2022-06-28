package top.alin.solution;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int i = (nums.length - 1) >> 1;
        int j = nums.length - 1;
        for(int idx = 0; idx < nums.length; idx++) {
            if (idx % 2 == 0) {
                nums[idx] = arr[i--];
            } else {
                nums[idx] = arr[j--];
            }
        }
    }
}
