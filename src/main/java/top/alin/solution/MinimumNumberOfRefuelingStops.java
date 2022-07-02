package top.alin.solution;

import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int total = 0, ans = 0, i = 0;
        int remain = startFuel;
        while(total < target) {
            if (remain == 0) {
                if (!q.isEmpty()) {
                    remain += q.poll();
                    ans++;
                } else {
                    return -1;
                }
            }
            total += remain;
            remain = 0;
            while(i < n && stations[i][0] <= total) {
                q.offer(stations[i++][1]);
            }
        }
        return ans;
    }
}
