package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dIndex = 0;
        List<Integer> ans = new ArrayList<>();
        int row = 0, col = -1;
        int total = m * n;
        for(int i = 0; i < total;) {
            int nextRow = row + directions[dIndex][0];
            int nextCol = col + directions[dIndex][1];
            if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && matrix[nextRow][nextCol] != 101) {
                ans.add(matrix[nextRow][nextCol]);
                matrix[nextRow][nextCol] = 101;
                row = nextRow;
                col = nextCol;
                ++i;
            } else {
                dIndex = (dIndex + 1) % directions.length;
            }
        }
        return ans;
    }
}
