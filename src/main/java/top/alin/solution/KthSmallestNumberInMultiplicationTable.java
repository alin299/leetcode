package top.alin.solution;

public class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int num = 0;
            for(int i = 1; i <= m; i++) {
                num += Math.min(n, mid / i);
            }
            if (num >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
