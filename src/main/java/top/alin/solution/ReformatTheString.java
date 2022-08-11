package top.alin.solution;

public class ReformatTheString {
    public String reformat(String s) {
        int numCount = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        for(char c : cs) {
            if (Character.isDigit(c)) {
                numCount++;
            }
        }
        int letterCount = n - numCount;
        if (Math.abs(numCount - letterCount) > 1) {
            return "";
        }

        boolean flag = numCount > letterCount;

        for(int i = 0, j = 1; i < n; i += 2) {
            if (Character.isDigit(cs[i]) != flag) {
                while(Character.isDigit(cs[j]) != flag) {
                    j += 2;
                }
                char temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
            }
        }
        return new String(cs);
    }
}
