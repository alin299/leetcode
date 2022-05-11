package top.alin.solution;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int ls = s.length();
        int lt = t.length();
        if (ls < lt) {
            return "";
        }
        Map<Character, Integer> ms = new HashMap<>();
        Map<Character, Integer> mt = new HashMap<>();
        for(int i = 0; i < lt; i++) {
            mt.put(t.charAt(i), mt.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        int minLen = ls + 1;
        int cnt = 0;
        for(int left = 0, right = 0; right < ls; right++) {
            ms.put(s.charAt(right), ms.getOrDefault(s.charAt(right), 0) + 1);
            if (mt.containsKey(s.charAt(right)) && ms.get(s.charAt(right)) <= mt.get(s.charAt(right))) {
                cnt++;
            }
            while(left < right && ms.get(s.charAt(left)) > mt.getOrDefault(s.charAt(left), 0)) {
                ms.put(s.charAt(left), ms.get(s.charAt(left)) - 1);
                left++;
            }
            if (cnt == lt && right - left + 1 < minLen) {
                minLen = right - left + 1;
                ans = s.substring(left, right + 1);
            }
        }
        return ans;
    }
}
