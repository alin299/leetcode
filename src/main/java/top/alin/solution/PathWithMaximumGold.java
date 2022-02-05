package top.alin.solution;

public class PathWithMaximumGold {
    int[][] grid;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int ans = 0;
    int m, n;
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] != 0) {
                    dfs(i, j, 0);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int cur) {
        cur += grid[i][j];
        ans = Math.max(ans, cur);

        int temp = grid[i][j];
        grid[i][j] = 0;
        for (int[] d : directions) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] != 0) {
                dfs(newI, newJ, cur);
            }
        }
        grid[i][j] = temp;
    }

    public static void main(String[] args) {
        PathWithMaximumGold solution = new PathWithMaximumGold();
        int[][] input = new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        System.out.println("solution.getMaximumGold(input) = " + solution.getMaximumGold(input));

    }
}
