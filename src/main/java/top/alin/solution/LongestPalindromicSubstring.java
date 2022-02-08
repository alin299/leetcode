package top.alin.solution;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int maxLen = 0;
        int start = 0;
        for(int i = 0; i < n;) {
            int left = i;
            int right = i;
            while(right < n - 1 && chars[right + 1] == chars[i]) {
                right++;
            }
            i = right + 1;
            while(left > 0 && right < n - 1 && chars[left - 1] == chars[right + 1]) {
                left--;
                right++;
            }
            if(right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
