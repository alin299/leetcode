package top.alin.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);
        double ans = Double.MAX_VALUE;
        int sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int i : ids) {
            sum += quality[i];
            q.offer(quality[i]);
            if (q.size() > k) {
                sum -= q.poll();
            }
            if (q.size() == k) {
                ans = Math.min(ans, (double) sum * wage[i] / quality[i]);
            }
        }
        return ans;
    }
}
