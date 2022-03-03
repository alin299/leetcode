package top.alin.solution;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= n - 1) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
