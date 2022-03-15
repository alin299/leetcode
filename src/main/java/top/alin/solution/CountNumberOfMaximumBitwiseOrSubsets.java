package top.alin.solution;

public class CountNumberOfMaximumBitwiseOrSubsets {
    int max, ans;
    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, 0, 0);
        return ans;
    }

    public void dfs(int[] nums, int start, int value) {
        if (start == nums.length) {
            if (value > max) {
                ans = 1;
                max = value;
            } else if (value == max) {
                ++ans;
            }
            return;
        }

        dfs(nums, start + 1, value | nums[start]);
        dfs(nums, start + 1, value);
    }
}
