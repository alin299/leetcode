package top.alin.solution;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] temp = new int[n];
        for(int i = 0; i < nums.length; i++) {
            temp[i + 1] = nums[i];
        }
        temp[0] = temp[n - 1] = 1;
        int[][] dp = new int[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                for(int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + temp[i] * temp[k] * temp[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
