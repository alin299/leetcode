package top.alin.solution;

public class RangeSumQuery2dImmutable {

//    int[][] preSum;
//    public RangeSumQuery2dImmutable(int[][] matrix) {
//        preSum = new int[matrix.length][matrix[0].length + 1];
//        for (int i = 0; i < matrix.length; ++i) {
//            for (int j = 1; j <= matrix[0].length; ++j) {
//                preSum[i][j] = preSum[i][j - 1] + matrix[i][j - 1];
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for(int i = row1; i <= row2; ++i) {
//            sum += preSum[i][col2 + 1] - preSum[i][col1];
//        }
//        return sum;
//    }

    int[][] preSum;
    int m, n;
    public RangeSumQuery2dImmutable(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        preSum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                preSum[i][j] = preSum[i - 1][j]
                        + preSum[i][j - 1]
                        - preSum[i - 1][ j - 1]
                        + matrix[i - 1][j -1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1]
                - preSum[row2 + 1][col1]
                - preSum[row1][col2 + 1]
                + preSum[row1][col1];
    }
}
