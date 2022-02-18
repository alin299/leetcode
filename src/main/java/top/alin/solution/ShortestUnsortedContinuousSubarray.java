package top.alin.solution;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0, end = - 1;
        int min = nums[nums.length - 1], max = nums[0];
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if(nums[nums.length - i - 1] > min) {
                start = nums.length - i - 1;
            } else {
                min = nums[nums.length - i - 1];
            }
        }
        return end - start + 1;
    }
}
