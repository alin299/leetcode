package top.alin.solution;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = mat[0][0];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + mat[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + mat[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j];
                }
            }
        }
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                ans[i][j] = getPreSum(dp, i + k, j + k)
                        - getPreSum(dp, i + k, j - k - 1)
                        - getPreSum(dp, i - k - 1, j + k)
                        + getPreSum(dp, i - k - 1, j - k - 1);
            }
        }
        return ans;

    }

    public int getPreSum(int[][] matrix, int row, int col){
        if (row < 0 || col < 0){
            return 0;
        }
        row = row > matrix.length-1 ? matrix.length-1 : row;
        col = col > matrix[row].length-1 ? matrix[row].length-1 : col;
        return matrix[row][col];
    }
}
