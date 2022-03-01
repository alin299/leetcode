package top.alin.solution;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; ++i) {
            if(i == 1) {
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];
    }
}
