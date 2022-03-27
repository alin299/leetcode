package top.alin.solution;

public class LongestIncreasingSubsequence {
    // dp
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        int max = 0;
//        for (int i = 0; i < n; ++i) {
//            dp[i] = 1;
//            for(int j = 0; j < i; j ++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[] tail = new int[n];
        tail[0] = nums[0];
        int end = 0;
        for(int i = 1; i < n; ++i) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                int left = 0, right = end;
                while(left < right) {
                    int mid = left + (right - left) / 2;
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        return end + 1;
    }
}
