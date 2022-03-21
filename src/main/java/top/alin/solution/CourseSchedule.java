package top.alin.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    // bfs
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            ++inDegrees[edge[0]];
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i <numCourses; ++i) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            --numCourses;
            for(int i : adj.get(curr)) {
                if (--inDegrees[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return numCourses == 0;
    }

    // dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] flags = new int[numCourses];
        for(int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < numCourses; ++i) {
            if (!dfs(adj, flags, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adj, int[] flags, int i) {
        if (flags[i] == 1) {
            return  false;
        } else if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (int next : adj.get(i)) {
            if (!dfs(adj, flags, next)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
