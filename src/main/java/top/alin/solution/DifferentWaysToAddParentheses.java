package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        char[] cs = expression.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i  < cs.length; i++) {
            if (!Character.isDigit(cs[i])) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, cs.length));
                for(Integer l : left) {
                    for(Integer r : right) {
                        switch(cs[i]) {
                            case '-':
                                ans.add(l - r);
                                break;
                            case '+':
                                ans.add(l + r);
                                break;
                            case '*':
                            default:
                                ans.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }
}
