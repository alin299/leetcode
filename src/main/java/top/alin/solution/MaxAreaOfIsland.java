package top.alin.solution;

public class MaxAreaOfIsland {
    int m;
    int n;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1;

        ans += dfs(i + 1, j);
        ans += dfs(i - 1, j);
        ans += dfs(i, j + 1);
        ans += dfs(i, j - 1);

        return ans;
    }
}
