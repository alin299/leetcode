package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class Shift2dGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        int[] arr = new int[total];
        k = k % (m * n);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[(i * n + j + k) % total] = grid[i][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> cur = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                cur.add(arr[i * n + j]);
            }
            ans.add(cur);
        }
        return ans;
    }
}
