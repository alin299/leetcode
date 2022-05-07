package top.alin.solution;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        char[] keys = new char[]{'A', 'C', 'G', 'T'};
        for (String s : bank) {
            bankSet.add(s);
        }
        if (start.equals(end)) {
            return 0;
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        int step = 0;
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                for(int j = 0; j < 8; j++)  {
                    for(int k = 0; k < keys.length; k++)  {
                        if (keys[k] != curr.charAt(j)) {
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (end.equals(next)) {
                                return step;
                            }
                            if (bankSet.contains(next) && !visited.contains(next)) {
                                q.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
