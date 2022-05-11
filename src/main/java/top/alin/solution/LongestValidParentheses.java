package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
            if (n == 0) {
                return 0;
            }
            int ans = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            for(int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        ans = Math.max(ans, i - stack.peek());
                    }
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public int longestValidParentheses(String s) {
            int n = s.length();
            if (n == 0) {
                return 0;
            }
            int ans = 0;
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1])  >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}
