package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n + 2];
        heights[0] = heights[n + 1] = -1;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                heights[j + 1] = matrix[i][j] == '0' ? 0 : (heights[j + 1] + 1);
            }
            Deque<Integer> q = new ArrayDeque();
            for(int j = 0; j < heights.length; j++) {
                while(!q.isEmpty() && heights[j] < heights[q.peek()]) {
                    int peek = q.pop();
                    ans = Math.max(ans, heights[peek] * (j - q.peek() - 1));
                }
                q.push(j);
            }
        }
        return ans;
    }
}
