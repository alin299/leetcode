package top.alin.solution;

import java.util.PriorityQueue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if(a > 0)q.add(new int[]{a, 'a'});
        if(b > 0)q.add(new int[]{b, 'b'});
        if(c > 0)q.add(new int[]{c, 'c'});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int len = sb.length();
            if(len >= 2 && sb.charAt(len - 1) == cur[1] && sb.charAt(len - 2) == cur[1]) {
                if(q.isEmpty()) {
                    break;
                }
                int[] next = q.poll();
                sb.append((char)next[1]);
                if(--next[0] > 0) {
                    q.add(next);
                }
                q.add(cur);
            } else {
                sb.append((char)cur[1]);
                if(--cur[0] > 0) {
                    q.add(cur);
                }
            }
        }
        return sb.toString();
    }

}
