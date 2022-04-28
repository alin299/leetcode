package top.alin.solution;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for(int i = 0, j = n - 1; i < j; i++, j--) {
            while(i < j && nums[j] % 2 == 1) {
                j--;
            }
            while(i < j && nums[i] % 2 == 0) {
                i++;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
