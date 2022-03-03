package top.alin.solution;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int max = 0;
        int end = 0;
        int ans = 0;
        for(int i = 0; i < n - 1; ++i) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                ++ans;
                end = max;
            }
        }
        return ans;
    }
}
