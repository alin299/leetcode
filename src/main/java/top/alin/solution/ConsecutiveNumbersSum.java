package top.alin.solution;

public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        n *= 2;
        for(int len = 1; len * len < n; len++) {
            if (n % len != 0) {
                continue;
            }
            if ((n / len - len + 1) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
