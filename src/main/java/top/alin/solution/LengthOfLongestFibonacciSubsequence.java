package top.alin.solution;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int[][] dp = new int[n][n];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            map.put(arr[i], i);
            for(int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                    ans = Math.max(ans, dp[j][i]);
                }
            }
        }
        return ans;
    }
}
