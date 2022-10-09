package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Deque<Integer> q =  new ArrayDeque<>();
        q.addLast(0);
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                q.addLast(0);
            } else {
                int cur = q.pollLast();
                q.addLast(q.pollLast() + Math.max(cur * 2, 1));
            }
        }
        return q.peekLast();
    }
}
