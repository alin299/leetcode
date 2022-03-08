package top.alin.solution;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n + 1];
        int[] l = new int[n];
        int[] r = new int[n];
        int p = -1, q = -1;
        char[] chars = s.toCharArray();
        for(int i = 0, j = n - 1; i < n;  ++i, --j) {
            if (chars[i] == '|') {
                p = i;
            }
            if (chars[j] == '|') {
                q = j;
            }
            l[i] = p;
            r[j] = q;
            sum[i + 1] = sum[i] + (chars[i] == '*' ? 1: 0);
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; ++i) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (r[a] != -1 && r[a] < l[b]) {
                ans[i] = sum[l[b] + 1] - sum[r[a] + 1];
            }
        }
        return ans;
    }
}
