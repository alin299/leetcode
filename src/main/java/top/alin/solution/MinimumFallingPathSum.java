package top.alin.solution;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for (int i = 1; i <= n; ++i) {
            int temp = 0, last = Integer.MAX_VALUE;
            for(int j = 0; j < n; ++j) {
                int ur = j == n - 1 ? Integer.MAX_VALUE : dp[j + 1];
                temp = dp[j];
                dp[j] = matrix[i - 1][j] + Math.min(last, Math.min(dp[j], ur));
                last = temp;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            ans = Math.min(ans,dp[j]);
        }
        return ans;
    }
}
