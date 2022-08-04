package top.alin.solution;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for(int i = 1; i < n; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        }
        int ans = left[n - 1];
        int right = 1;
        for(int i = n - 2; i >= 0; i--) {
            right = ratings[i] > ratings[i + 1] ? right + 1 : 1;
            ans += Math.max(left[i], right);
        }
        return ans;
    }
}
