package top.alin.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String s : banned) {
            set.add(s);
        }
        char[] cs = paragraph.toCharArray();
        int n = cs.length;
        String ans = null;
        for(int i = 0; i < n;) {
            if (!Character.isLetter(cs[i]) && ++i > 0) {
                continue;
            }
            int j = i;
            while(j < n && Character.isLetter(cs[j])) {
                j++;
            }
            String sub = paragraph.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub)) {
                continue;
            }
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) {
                ans = sub;
            }
        }
        return ans;
    }
}
