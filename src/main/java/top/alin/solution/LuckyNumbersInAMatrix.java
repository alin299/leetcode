package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i = 0; i < m; ++i) {
            row[i] = Integer.MAX_VALUE;
            for(int j = 0; j < n; ++j) {
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == row[i] && matrix[i][j] == col[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}
