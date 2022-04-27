package top.alin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m;
    int n;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        this.heights = heights;
        for(int col = 0; col < n; col++) {
            dfs(pacific, 0, col);
        }
        for(int row = 0; row < m; row++) {
            dfs(pacific, row, 0);
        }
        for(int col = 0; col < n; col++) {
            dfs(atlantic, m - 1, col);
        }
        for(int row = 0; row < m; row++) {
            dfs(atlantic, row, n - 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    ans.add(Arrays.asList(row, col));
                }
            }
        }
        return ans;
    }

    void dfs(boolean[][] ocean, int row, int col) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for(int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (0 <= newRow && newRow < m && 0 <= newCol && newCol < n && heights[row][col] <= heights[newRow][newCol]) {
                dfs(ocean, newRow, newCol);
            }
        }
    }
}
