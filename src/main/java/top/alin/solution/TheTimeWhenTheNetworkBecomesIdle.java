package top.alin.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TheTimeWhenTheNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new ArrayDeque();
        q.offer(0);
        visited[0] = true;
        int distance = 1;
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                int curr = q.poll();
                for(int v : adj.get(curr)) {
                    if (visited[v]) {
                        continue;
                    }
                    q.offer(v);
                    int res = (2 * distance - 1) / patience[v] * patience[v] + 2 * distance + 1;
                    ans = Math.max(ans, res);
                    visited[v] = true;
                }
            }
            ++distance;
        }
        return ans;
    }
}
