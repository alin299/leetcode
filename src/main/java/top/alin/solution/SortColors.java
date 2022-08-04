package top.alin.solution;

public class SortColors {

    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for(int i = 0; i <= p2; i++) {
            while(i <= p2 && nums[i] == 2) {
                swap(nums, i, p2--);
            }

            if (nums[i] == 0) {
                swap(nums, p0++, i);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
