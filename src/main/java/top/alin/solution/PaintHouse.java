package top.alin.solution;

import java.util.Arrays;

public class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = Arrays.copyOf(costs[0], 3);
        for(int i = 1; i < n; i++) {
            int[] temp = new int[3];
            temp[0] = Math.min(dp[1], dp[2]) + costs[i][0];
            temp[1] = Math.min(dp[0], dp[2]) + costs[i][1];
            temp[2] = Math.min(dp[0], dp[1]) + costs[i][2];
            dp = temp;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
