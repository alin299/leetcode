package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        int len = charsP.length;
        int[] counts = new int[26];
        for(int i = 0; i < len; i++) {
            counts[charsP[i] - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < charsS.length - len + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < len; j++) {
                    counts[charsS[j] - 'a']--;
                }
            } else {
                counts[charsS[i - 1] - 'a']++;
                counts[charsS[i + len - 1] - 'a']--;
            }
            if(count(counts) == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
    public int count(int[] counts) {
        int ans = 0;
        for(int i = 0; i < counts.length; i++) {
            if(counts[i] != 0) {
                ans++;
            }
        }
        return ans;
    }
}
