package top.alin.solution;

import java.util.Arrays;

public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int curr = 0;
        for(int i = 0; i < n; i++) {
            curr += i * nums[i];
        }
        int ans = curr;
        for (int i = n - 1; i > 0; i--) {
            curr = curr + sum - n * nums[i];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
