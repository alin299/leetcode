package top.alin.solution;

public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        int max = values[0];
        for (int j = 1; j < n; ++j) {
            ans = Math.max(ans, values[j] - j + max);
            max = Math.max(max, values[j] + j);
        }
        return ans;
    }
}
