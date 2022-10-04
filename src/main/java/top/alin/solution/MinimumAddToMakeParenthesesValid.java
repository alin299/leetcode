package top.alin.solution;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int ans = 0, left = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    ans++;
                }
            }
        }
        return ans + left;
    }
}
