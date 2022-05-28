package top.alin.solution;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int lc = 0;
        for(char c : s.toCharArray()) {
            if (c == ')') {
                lc--;
            }
            if (lc != 0) {
                stringBuffer.append(c);
            }
            if (c == '(') {
                lc++;
            }
        }
        return stringBuffer.toString();
    }
}
