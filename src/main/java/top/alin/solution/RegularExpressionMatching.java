package top.alin.solution;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = p.toCharArray();
        int n1 = chars1.length;
        int n2 = chars2.length;

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n2; j++) {
            if (chars2[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (chars1[i - 1] == chars2[j - 1] || chars2[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (chars2[j - 1] == '*') {
                    if (chars1[i - 1] == chars2[j - 2] || chars2[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]
                                || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[n1][n2];
    }
}
