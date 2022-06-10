package top.alin.solution;

import java.util.Arrays;

public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String s) {
        int MOD = (int) 1e9 + 7;
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] L = new int[4];
        int[] R = new int[4];
        int[][] dp = new int[n][n];
        Arrays.fill(L, -1);
        for (int i = n - 1; i >= 0; i--) {
            L[cs[i] - 'a'] = i;
            Arrays.fill(R, -1);
            for (int j = i; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    R[cs[j] - 'a'] = j;
                    int l = L[k];
                    int r = R[k];
                    if (l == -1 || r == -1) {
                        continue;
                    } else if (l == r) {
                        dp[i][j] = (dp[i][j] + 1) % MOD;
                    } else if (l == r - 1) {
                        dp[i][j] = (dp[i][j] + 2) % MOD;
                    } else {
                        dp[i][j] = (dp[i][j] + dp[l + 1][r - 1] + 2) % MOD;
                    }
                }

            }
        }
        return dp[0][n - 1];
    }
}
