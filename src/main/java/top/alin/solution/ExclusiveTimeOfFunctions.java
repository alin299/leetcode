package top.alin.solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        int last = -1;
        for(String log : logs) {
            String[] _logs = log.split(":");
            int id = Integer.valueOf(_logs[0]);
            int time = Integer.valueOf(_logs[2]);
            if (_logs[1].equals("start")) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += time - last;
                }
                stack.push(id);
                last = time;
            } else {
                int cur = stack.pop();
                ans[cur] += time - last + 1;
                last = time + 1;
            }
        }
        return ans;
    }
}
