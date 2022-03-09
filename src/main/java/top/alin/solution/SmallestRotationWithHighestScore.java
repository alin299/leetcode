package top.alin.solution;

public class SmallestRotationWithHighestScore {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int minK = 0;
        int score = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            if (nums[i] > i) {
                ++arr[n + i - nums[i]];
            } else {
                ++arr[i - nums[i]];
                ++score;
            }
        }
        int maxScore = score;
        for(int k = 1; k < n; ++k) {
            score = score - arr[k - 1] + 1;
            if (score > maxScore) {
                maxScore = score;
                minK = k;
            }
        }
        return minK;
    }
}
