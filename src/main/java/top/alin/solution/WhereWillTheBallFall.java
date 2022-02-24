package top.alin.solution;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];

        out:for(int i = 0; i < n; ++i) {
            int position = i;
            for(int j = 0; j < m; ++j) {
                int v = grid[j][position];
                position += grid[j][position];
                if(position < 0 || position >= n || grid[j][position] != v) {
                    ans[i] = -1;
                    continue out;
                }
            }

            ans[i] = position;
        }
        return ans;
    }
}
