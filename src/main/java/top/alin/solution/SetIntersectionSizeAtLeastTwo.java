package top.alin.solution;

import java.util.Arrays;

public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = intervals.length;
        int left = intervals[n - 1][0], right = left + 1;
        int ans = 2;
        for(int i = n - 2; i >= 0; i--) {
            if (intervals[i][1] >= right) {
                continue;
            } else if (intervals[i][1] < left) {
                left = intervals[i][0];
                right = left + 1;
                ans += 2;
            } else {
                right = left;
                left = intervals[i][0];
                ans++;
            }
        }
        return ans;
    }
}
