package top.alin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int[] map = new int[26];
        boolean[] visited = new boolean[26];
        for(String word : words) {
            Arrays.fill(map, -1);
            Arrays.fill(visited, false);
            boolean valid = true;
            for(int i = 0; i < word.length(); i++) {
                int x = word.charAt(i) - 'a';
                int y = pattern.charAt(i) - 'a';
                if (map[x] == -1 && !visited[y]) {
                    map[x] = y;
                    visited[y] = true;
                } else if (map[x] != y) {
                    valid = false;
                }
            }
            if (valid) {
                ans.add(word);
            }
        }
        return ans;
    }
}
