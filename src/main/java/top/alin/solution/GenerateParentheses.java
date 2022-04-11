package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    void backtrack(List<String> ans, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            ans.add(sb.toString());
            return;
        }

        if (open < max) {
            backtrack(ans, sb.append('('), open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < max && close < open) {
            backtrack(ans, sb.append(')'), open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
