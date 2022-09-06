package top.alin.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map= new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
                map.get(c).add(-1);
            }
            map.get(c).add(i);
        }

        int ans = 0;
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            list.add(n);
            for(int i = 1; i < list.size() - 1; i++) {
                ans += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
            }
        }
        return ans;
    }
}
