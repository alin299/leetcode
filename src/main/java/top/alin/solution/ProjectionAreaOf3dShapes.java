package top.alin.solution;

public class ProjectionAreaOf3dShapes {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for(int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for(int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[i][j]);
                zxHeight = Math.max(zxHeight, grid[j][i]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }
}
