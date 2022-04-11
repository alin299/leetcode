package top.alin.solution;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10;
        int curr = 9;
        for (int i = 0; i < n - 1; i++) {
            curr *= (9 - i);
            ans += curr;
        }
        return ans;
    }
}
