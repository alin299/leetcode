package top.alin.solution;

import java.util.HashMap;
import java.util.Map;

public class PrefixAndSuffixSearch {
    Map<String, Integer> map;
    public PrefixAndSuffixSearch(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 1; j <= words[i].length(); j++) {
                for(int k = 1; k <= words[i].length(); k++) {
                    map.put(words[i].substring(0, j) + " " + words[i].substring(words[i].length() - k), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + " "+ suff, -1);
    }
}
