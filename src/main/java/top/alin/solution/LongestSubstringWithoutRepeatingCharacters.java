package top.alin.solution;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int ans = 1;
        for(int left = 0, right = 1; right < chars.length; right++) {
            int i = left;
            while(i < right && chars[i] != chars[right]) {
                i++;
            }
            if (i < right) {
                left = i + 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
