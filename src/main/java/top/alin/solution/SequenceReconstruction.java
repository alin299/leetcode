package top.alin.solution;

import java.util.*;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        int n = nums.length;
        int[] inDegree = new int[n];
        for(List<Integer> sequence : sequences) {
            for(int i = 1; i < sequence.size(); i++) {
                int from = sequence.get(i - 1), to = sequence.get(i);
                if (!edges.containsKey(from)) {
                    edges.put(from, new HashSet<>());
                }
                edges.get(from).add(to);
                inDegree[to - 1]++;
            }

        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i + 1);
            }
        }
        while(!q.isEmpty()) {
            if (q.size() > 1) {
                return false;
            }
            Set<Integer> set = edges.get(q.poll());
            if (set == null) {
                continue;
            }
            for(Integer to : set) {
                if (--inDegree[to - 1] == 0) {
                    q.offer(to);
                }
            }
        }
        return true;
    }
}
