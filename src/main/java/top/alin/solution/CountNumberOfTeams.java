package top.alin.solution;

public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int ans = 0;
        int n  = rating.length;
        for (int j = 1; j < n - 1; j++) {
            int iless = 0, imore = 0;
            int kmore = 0, kless = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    iless++;
                }
                if (rating[i] > rating[j]) {
                    imore++;
                }
            }
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    kless++;
                }
                if (rating[k] > rating[j]) {
                    kmore++;
                }
            }
            ans += iless * kmore + imore * kless;
        }
        return ans;
    }
}
