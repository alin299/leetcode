package top.alin.solution;

import top.alin.utils.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Deque;

public class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        int h = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0 ) {
                int[] item = q.pollFirst();
                int i = item[0], j = item[1];
                for (int[] d : directions) {
                    int newI = i + d[0];
                    int newJ = j + d[1];
                    if(newI < 0 || newI >= m || newJ < 0 || newJ >= n || ans[newI][newJ] != -1) {
                        continue;
                    }
                    ans[newI][newJ] = h;
                    q.addLast(new int[]{newI, newJ});
                }
            }
            h++;
        }
        return ans;
    }

}
