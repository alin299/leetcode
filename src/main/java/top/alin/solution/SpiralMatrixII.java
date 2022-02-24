package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int total = n * n;
        int[][] ans = new int[n][n];
        int row = 0, col = -1;
        for(int i = 0; i < total;) {
            int nextRow = row + directions[index][0];
            int nextCol = col + directions[index][1];
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || ans[nextRow][nextCol] != 0) {
                index = (index + 1) % directions.length;
                continue;
            }
            ans[nextRow][nextCol] = ++i;
            row = nextRow;
            col = nextCol;

        }
        return ans;
    }
}
