package top.alin.solution;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            ans = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                ans.add(curr);
                if (!map.containsKey(curr)) {
                    continue;
                }
                for (int adj : map.get(curr)) {
                    if (--degree[adj] == 1) {
                        q.add(adj);
                    }
                }
            }
        }
        return ans;
    }
}