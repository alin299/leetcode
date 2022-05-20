package top.alin.solution;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = intervals.length;
        int index = -1;
        for(int i = 0; i < n; i++) {
            if (index == -1 || intervals[i][1] > intervals[index][1]) {
                index++;
                intervals[index][0] = intervals[i][0];
                intervals[index][1] = intervals[i][1];
            }
        }
        return index + 1;
    }
}
