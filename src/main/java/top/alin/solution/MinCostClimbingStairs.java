package top.alin.solution;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length + 1];
        for(int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }
}
