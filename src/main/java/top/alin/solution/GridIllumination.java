package top.alin.solution;

import java.util.*;

public class GridIllumination {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;
        Map<Integer, Integer> row  = new HashMap<>();
        Map<Integer, Integer> col  = new HashMap<>();
        Map<Integer, Integer> pDiagonal  = new HashMap<>();
        Map<Integer, Integer> nDiagonal  = new HashMap<>();
        Set<Long> set = new HashSet<>();

        for(int[] lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            if(!set.add(x * N + y)) {
                continue;
            }
            increment(row, x);
            increment(col, y);
            increment(pDiagonal, y - x);
            increment(nDiagonal, y + x);
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; ++i) {
            int x = queries[i][0], y = queries[i][1];
            if (row.containsKey(x) || col.containsKey(y)
                    || pDiagonal.containsKey(y - x)
                    || nDiagonal.containsKey(x + y)) {
                ans[i] = 1;
            }
            for(int r = x - 1; r <= x + 1; ++r) {
                for(int c = y - 1; c <= y + 1; ++c) {
                    if(r < 0 || r >= n || c < 0 || c >= n) {
                        continue;
                    }
                    if(!set.remove(r * N + c)) {
                        continue;
                    }
                    decrement(row, r);
                    decrement(col, c);
                    decrement(pDiagonal, c - r);
                    decrement(nDiagonal, c + r);

                }
            }
        }
        return ans;
    }
    void increment(Map<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    void decrement(Map<Integer, Integer> map, int key) {
        int count = map.getOrDefault(key, 0);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}
