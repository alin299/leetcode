package top.alin.solution;

public class PalindromicSubstrings {
    public int countSubstrings1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for(int j = 0; j < n; ++j) {
            for(int i = 0; i <= j; ++i) {
                if(chars[i] == chars[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;
        for(int i = 0; i < n * 2 - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;

            while(left >= 0 && right < n && chars[left] == chars[right]) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

}