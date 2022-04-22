package top.alin.solution;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        BitSet bitSet = new BitSet();
        for(int[] interval : intervals) {
            bitSet.set(interval[0] * 2, (interval[1]) * 2 + 1);
        }
        List<int[]> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        while((start = bitSet.nextSetBit(end)) != -1) {
            end = bitSet.nextClearBit(start);
            ans.add(new int[]{start / 2, (end - 1) / 2});

        }
        return ans.toArray(new int[0][]);
    }
}
