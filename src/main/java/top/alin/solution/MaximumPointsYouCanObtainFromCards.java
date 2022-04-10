package top.alin.solution;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for(int point : cardPoints) {
            total += point;
        }

        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += cardPoints[i];
        }
        int ans = total - sum;

        for(int i = n - k; i < n; i++) {
            sum += cardPoints[i];
            sum -= cardPoints[i - n + k];
            ans = Math.max(ans, total - sum);
        }
        return ans;
    }
}
