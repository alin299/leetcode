package top.alin.solution;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        int n = s.length();
        int width = 0;
        int lines = 1;
        for(int i = 0; i < n; i++) {
            int need = widths[s.charAt(i) - 'a'];
            width += need;
            if (width > 100) {
                width = need;
                lines++;
            }
        }
        return new int[]{lines, width};
    }
}
