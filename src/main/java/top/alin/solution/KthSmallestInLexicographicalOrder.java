package top.alin.solution;

public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        k -= 1;
        while (k > 0) {
            int nodes = getCount(curr, n);
            if (k >= nodes) {
                k -= nodes;
                ++curr;
            } else {
                k -= 1;
                curr *= 10;
            }
        }
        return (int)curr;
    }

    public int getCount(long curr, int n) {
        int count = 0;
        long next = curr + 1;
        while (curr <= n) {
            count += Math.min(n - curr + 1, next - curr);
            curr *= 10;
            next *= 10;
        }
        return count;
    }
}
