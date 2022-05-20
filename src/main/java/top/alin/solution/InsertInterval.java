package top.alin.solution;

import java.util.List;
import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        for(int[] interval : intervals) {
            if (right < interval[0]) {
                if (!placed) {
                    res.add(new int[]{left, right});
                    placed = true;
                }
                res.add(new int[]{interval[0], interval[1]});
            } else if (left > interval[1]) {
                res.add(new int[]{interval[0], interval[1]});
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if (!placed) {
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[res.size()][]);
    }
}
