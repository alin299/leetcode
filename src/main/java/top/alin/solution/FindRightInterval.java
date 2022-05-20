package top.alin.solution;

import java.util.Arrays;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        int[][] startIntervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }
}
