package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while(!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int peek = stack.pop();
                int left = stack.peek();
                ans = Math.max(ans, new_heights[peek] * (i - left - 1));
            }
            stack.push(i);
        }
        return ans;
    }
}
