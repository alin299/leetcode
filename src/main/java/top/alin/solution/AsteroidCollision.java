package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> q = new ArrayDeque<>();
        out: for(int asteroid : asteroids) {
            while(!q.isEmpty() && asteroid < 0 && q.peekLast() > 0) {
                if (-asteroid > q.peekLast()) {
                    q.pollLast();
                    continue;
                }
                if (-asteroid == q.peekLast()) {
                    q.pollLast();
                }
                continue out;
            }
            q.offer(asteroid);
        }
        int n = q.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = q.pollFirst();
        }
        return ans;
    }
}
