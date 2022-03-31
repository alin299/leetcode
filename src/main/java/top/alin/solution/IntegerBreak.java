package top.alin.solution;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i <= n; ++i) {
            for(int j = 2; j < i; ++j) {
                dp[i] = Math.max(dp[i], dp[i - j] * j);
                dp[i] = Math.max(dp[i], (i - j) * j);
            }
        }
        return dp[n];
    }
}
