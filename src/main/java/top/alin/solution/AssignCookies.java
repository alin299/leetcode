package top.alin.solution;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = s.length - 1;
        int ans = 0;
        for(int j = g.length - 1; j >= 0; j--) {
            if (i >= 0 && g[j] <= s[i]) {
                i--;
                ans++;
            }
        }
        return ans;
    }
}
