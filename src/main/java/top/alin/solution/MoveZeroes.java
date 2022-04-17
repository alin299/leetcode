package top.alin.solution;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                if (left == right) {
                    left++;
                    continue;
                }
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;
            }
        }
    }
}
