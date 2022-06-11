package top.alin.solution;

public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int dp0 = 0, dp1= 0;
        for(char c : s.toCharArray()) {
            dp1 = Math.min(dp0, dp1);
            if (c == '1') {
                dp0++;
            } else {
                dp1++;
            }
        }
        return Math.min(dp0, dp1);
    }
    public int minFlipsMonoIncr2(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + cs[i - 1] - '0';
        }
        int ans = n;
        for(int i = 1; i <= n; i++) {
            int l = sum[i - 1];
            int r = (n - i) - (sum[n] - sum[i]);
            ans = Math.min(ans, l + r);
        }
        return ans;
    }
}
