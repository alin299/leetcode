package top.alin.solution;

import java.util.Arrays;

public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int len = 0;
        for(int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                len++;
            } else {
                len = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], len);
        }
        return Arrays.stream(dp).sum();
    }
}
