package top.alin.solution;

public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int min = nums[0];
        int cur = 0;
        for(int num : nums) {
            cur += num;
            min = Math.min(min, cur);
        }
        return  Math.max(1,  1 - min);
    }
}
