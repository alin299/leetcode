package top.alin.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < w; i++) {
            Map<String, Integer> curMap = new HashMap<>();
            for(int j = i; j + w <= n; j+=w) {
                String cur = s.substring(j, j + w);
                curMap.put(cur, curMap.getOrDefault(cur, 0) + 1);
                if (j >= i + m * w) {
                    int preIdx =  j - m * w;
                    String pre = s.substring(preIdx, preIdx + w);
                    if (curMap.get(pre) == 1) {
                        curMap.remove(pre);
                    } else {
                        curMap.put(pre, curMap.get(pre) - 1);
                    }
                }
                if (curMap.equals(map)) {
                    ans.add(j - (m - 1) * w);
                }
            }
        }
        return ans;
    }
}
