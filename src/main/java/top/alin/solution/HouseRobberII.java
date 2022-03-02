package top.alin.solution;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    public int rob(int[] nums, int start, int end) {
        int max = nums[start];
        int pre = nums[start + 1];
        int ans = Math.max(max, pre);
        for(int i = start + 2; i <= end; ++i) {
            ans = max + nums[i];
            max = Math.max(max, pre);
            pre = ans;
        }
        return Math.max(ans, max);
    }

}
