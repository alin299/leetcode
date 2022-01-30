package top.alin.solution;

import java.util.*;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : arr1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : arr2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if(item.getValue() == 1) {
                ans.add(item.getKey());
            }
        }

        return ans.toArray(new String[ans.size()]);

    }

}
