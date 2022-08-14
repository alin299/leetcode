package top.alin.solution;

public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (cs[i - 1] - '0');
        }

        int ans = 0;
        for(int i = 1; i <= n - 1; i++) {
            int left = i - sum[i];
            int right = sum[n] - sum[i];
            ans = Math.max(ans, left + right);
        }
        return ans;
    }
}
