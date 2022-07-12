package top.alin.solution;

public class CellsWithOddValuesInAMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for(int[] index : indices) {
            rows[index[0]] = !rows[index[0]];
            cols[index[1]] = !cols[index[1]];
        }
        int oddx = 0, oddy = 0;
        for(boolean row : rows) {
            if (row) {
                oddx++;
            }
        }
        for(boolean col : cols) {
            if (col) {
                oddy++;
            }
        }
        return oddx * (n - oddy) + oddy * (m - oddx);
    }
}
