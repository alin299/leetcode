package top.alin.solution;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        int top = -1;
        for(int i = 0; i < cs.length; i++) {
            if (top >= 0 && cs[top] == cs[i]) {
                top--;
            } else {
                cs[++top] = cs[i];
            }
        }
        return String.valueOf(cs, 0, top + 1);
    }
}
