package top.alin.solution;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; ++i) {
            int min = amount + 1;
            for(int j = coins.length - 1; j >= 0; --j) {
                if(i >= coins[j]) {
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            dp[i] = min + 1;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
