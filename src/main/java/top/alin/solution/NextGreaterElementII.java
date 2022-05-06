package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < 2 * n; i++) {
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int peek = stack.pop();
                ans[peek] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return ans;
    }
}
