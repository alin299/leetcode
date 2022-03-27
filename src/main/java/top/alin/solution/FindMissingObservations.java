package top.alin.solution;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = (m + n) * mean;
        for (int i = 0; i < m; ++i) {
            sum -= rolls[i];
        }
        if (sum < n ||sum > 6 * n) {
            return new int[]{};
        }
        int[] ans = new int[n];
        mean = sum / n;
        int k = sum % n;
        for (int i = 0; i < n; ++i) {
            ans[i] = mean + (i < k ? 1 : 0);
        }
        return ans;
    }
}
