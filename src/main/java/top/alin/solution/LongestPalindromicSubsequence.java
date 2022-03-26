package top.alin.solution;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; ++j) {
            dp[j][j] = 1;
            for (int i = j - 1; i >= 0; --i) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
