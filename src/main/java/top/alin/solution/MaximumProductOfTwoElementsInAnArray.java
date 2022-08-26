package top.alin.solution;

public class MaximumProductOfTwoElementsInAnArray {
    public int maxProduct(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }
}
