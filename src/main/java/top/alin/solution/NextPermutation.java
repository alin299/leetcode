package top.alin.solution;


public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        while(index >= 0 && (nums[index] >= nums[index + 1])) {
            index--;
        }
        if(index >= 0) {
            for(int i = nums.length - 1; i > index; --i) {
                if(nums[index] < nums[i]) {
                    swap(nums, index, i);
                    break;
                }
            }
        }
        for(int i = nums.length - 1; i > index; --i) {
            swap(nums, ++index, i);
        }
    }
    public void swap(int[] nums, int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
