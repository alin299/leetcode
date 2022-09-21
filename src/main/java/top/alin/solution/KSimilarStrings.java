package top.alin.solution;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KSimilarStrings {
    public int kSimilarity(String s1, String s2) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(s1, 0);
        q.offer(s1);
        int n = s2.length();

        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(s2)) return step;
                int pos = map.get(cur);
                while (pos < n && cur.charAt(pos) == s2.charAt(pos)) pos++;
                for (int j = pos + 1; j < n; j++) {
                    if (cur.charAt(j) == s2.charAt(j)) continue;
                    if (cur.charAt(j) == s2.charAt(pos)) {
                        String next = swap(cur, pos, j);
                        if (!map.containsKey(next)) {
                            map.put(next, pos + 1);
                            q.offer(next);
                        }
                    }
                }
            }

            step++;
        }
        return step;
    }

    public String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
}
