package top.alin.solution;

import java.util.Arrays;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[] dp = Arrays.copyOf(costs[0], k);
        for(int i = 1; i < n; i++) {
            int[] temp = new int[k];
            for(int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for(int t = 0; t < k; t++) {
                    if (t != j) {
                        min = Math.min(min, dp[t]);
                    }
                }
                temp[j] = min + costs[i][j];
            }
            dp = temp;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
