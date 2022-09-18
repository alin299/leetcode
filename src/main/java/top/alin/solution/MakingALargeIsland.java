package top.alin.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakingALargeIsland {
    int n;
    int[][] tag;
    List<Integer> list;
    public int largestIsland(int[][] grid) {
        n = grid.length;
        tag = new int[n][n];
        list = new ArrayList<>();
        list.add(0);
        int ans = 0;
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, idx++);
                    list.add(area);
                    ans = Math.max(ans, area);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, getArea(i, j));
                }
            }
        }
        return ans;
    }

    int getArea(int i, int j) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        if (i > 0) set.add(tag[i - 1][j]);
        if (j > 0) set.add(tag[i][j - 1]);
        if (i < n - 1) set.add(tag[i + 1][j]);
        if (j < n - 1) set.add(tag[i][j + 1]);

        for (Integer id : set) {
            res += list.get(id);
        }

        return res + 1;
    }

    int dfs(int[][] grid, int i, int j, int idx) {
        if (i < 0 || j < 0 || i >= n ||j >= n || grid[i][j] <= 0) return 0;
        grid[i][j] = -1;
        tag[i][j] = idx;
        int res = 1;

        res += dfs(grid, i + 1, j, idx);
        res += dfs(grid, i - 1, j, idx);
        res += dfs(grid, i, j + 1, idx);
        res += dfs(grid, i, j - 1, idx);

        return res;
    }

}
