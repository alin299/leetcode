package top.alin.solution;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int i = 0, j = 0;
        while(i < chars1.length && j < chars2.length) {
            if (chars1[i] == chars2[j]) {
                ++i;
            }
            ++j;
        }
        return i == chars1.length;
    }
}
