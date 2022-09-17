package top.alin.solution;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i) - 'a'] < 0) {
                idx[s.charAt(i) - 'a'] = i;
            } else {
                ans = Math.max(ans, i - idx[s.charAt(i) - 'a'] - 1);
            }
        }
        return ans;
    }
}
