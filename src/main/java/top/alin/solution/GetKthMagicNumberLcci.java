package top.alin.solution;

public class GetKthMagicNumberLcci {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for(int i = 2; i <= k; ++i) {
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            int num7 = dp[p7] * 7;
            dp[i] = Math.min(num3, Math.min(num5, num7));
            if (dp[i] == num3) {
                ++p3;
            }
            if (dp[i] == num5) {
                ++p5;
            }
            if (dp[i] == num7) {
                ++p7;
            }
        }
        return dp[k];
    }
}
