package top.alin.solution;

public class KnightProbabilityInChessboard {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] directions = new int[][]{{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
        double[][][] dp = new double[n][n][k + 1];
        for(int step = 0; step <= k; ++step) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(step == 0) {
                        dp[i][j][step] = 1.0;
                        continue;
                    }
                    double res = 0;
                    for(int[] d : directions) {
                        int nextRow = i + d[0];
                        int nextColumn = j + d[1];
                        if(nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n) {
                            continue;
                        }
                        res += dp[nextRow][nextColumn][step - 1];
                    }
                    dp[i][j][step] = res / 8;
                }
            }
        }
        return dp[row][column][k];
    }
}
