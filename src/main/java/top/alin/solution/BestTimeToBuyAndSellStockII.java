package top.alin.solution;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i -  1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
