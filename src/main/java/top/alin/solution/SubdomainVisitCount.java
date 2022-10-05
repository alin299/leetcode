package top.alin.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : cpdomains) {
            String[] arr = s.split(" ");
            int num = Integer.parseInt(arr[0]);
            s = arr[1];
            map.put(s, map.getOrDefault(s, 0) + num);
            for(int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '.') {
                    String t = s.substring(i + 1);
                    map.put(t, map.getOrDefault(t, 0) + num);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(String.format("%d %s", entry.getValue(), entry.getKey()));
        }
        return ans;
    }
}
