package top.alin.solution;

public class LongestNiceSubstring {
    public String longestNiceSubstring1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int maxPos = 0;
        int maxLen = 0;
        for(int i = 0; i < n; ++i) {
            int a = 0, b = 0;
            for(int j = i; j < n; ++j) {
                if(Character.isLowerCase(chars[j])) {
                    a |= (1 << chars[j] - 'a');
                } else {
                    b |= (1 << chars[j] - 'A');
                }
                if (a == b && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    maxPos = i;
                }
            }

        }
        return s.substring(maxPos, maxPos + maxLen);
    }
    public String longestNiceSubstring(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if((Character.isLowerCase(c) && !s.contains(String.valueOf(Character.toUpperCase(c))))
                    || (Character.isUpperCase(c) && !s.contains(String.valueOf(Character.toLowerCase(c))))) {
                String s1 = longestNiceSubstring(s.substring(0, i));
                String s2 = longestNiceSubstring(s.substring(i + 1));
                if (s1.length() >= s2.length()) {
                    return s1;
                } else {
                    return s2;
                }
            }
        }
        return s;
    }

}
