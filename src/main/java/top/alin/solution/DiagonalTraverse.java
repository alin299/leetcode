package top.alin.solution;

import java.util.PriorityQueue;

public class DiagonalTraverse {
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int total = m * n;
            int x = 0, y = 0;
            int[] ans = new int[total];
            for(int i = 0; i < total; i++) {
                ans[i] = mat[x][y];
                if ((x + y) % 2 == 0) {
                    if (y == n - 1) {
                        x++;
                    } else if (x == 0) {
                        y++;
                    } else {
                        x--;
                        y++;
                    }
                } else {
                    if (x == m - 1) {
                        y++;
                    } else if (y == 0) {
                        x++;
                    } else {
                        x++;
                        y--;
                    }
                }
            }
            return ans;
        }
    }
    class Solution2 {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
                if (a[0] + a[1] != b[0] + b[1]) {
                    return a[0] + a[1] - b[0] - b[1];
                } else {
                    if ((a[0] + a[1]) % 2 == 1) {
                        return a[0] - b[0];
                    } else {
                        return b[0] - a[0];
                    }
                }
            });
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    q.offer(new int[]{i, j});
                }
            }
            int[] ans = new int[q.size()];
            int i = 0;
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                ans[i++] = mat[cur[0]][cur[1]];
            }
            return ans;
        }
    }
}
