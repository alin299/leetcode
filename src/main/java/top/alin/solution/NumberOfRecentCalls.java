package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfRecentCalls {
    class RecentCounter {
        Deque<Integer> q;
        public RecentCounter() {
            q = new ArrayDeque<>();
        }

        public int ping(int t) {
            q.offer(t);
            while(!q.isEmpty() && q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();
        }
    }
}
