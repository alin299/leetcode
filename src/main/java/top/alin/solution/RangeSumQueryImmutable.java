package top.alin.solution;

public class RangeSumQueryImmutable {
    int[] preSum;
    public RangeSumQueryImmutable(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; ++i) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
