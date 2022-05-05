package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    class Solution1 {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length];
            for(int i = temperatures.length - 2; i >= 0; i--) {
                for(int j = i + 1; j < temperatures.length; j += ans[j]) {
                    if(temperatures[i] < temperatures[j]) {
                        ans[i] = j - i;
                        break;
                    } else if (ans[j] == 0){
                        ans[i] = 0;
                        break;
                    }
                }
            }
            return ans;
        }
    }
    class Solution2 {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int peek = stack.pop();
                    ans[peek] = i - peek;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
