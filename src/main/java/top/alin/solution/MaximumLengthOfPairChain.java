package top.alin.solution;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE;
        int ans = 0;
        for(int[] p : pairs) {
            if (cur < p[0]) {
                ans++;
                cur = p[1];
            }
        }
        return ans;
    }
}
