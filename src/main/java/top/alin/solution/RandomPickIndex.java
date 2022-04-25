package top.alin.solution;

import java.util.Random;

public class RandomPickIndex {
    Random r;
    int[] nums;
    public RandomPickIndex(int[] nums) {
        r = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target && r.nextInt(++cnt) == 0) {
                ans = i;
            }
        }
        return ans;
    }
}
