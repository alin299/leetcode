package top.alin.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickWithBlacklist {
    class Solution {
        Random r;
        int len;
        Map<Integer, Integer> map;
        public Solution(int n, int[] blacklist) {
            r = new Random();
            len = n - blacklist.length;
            map = new HashMap<>();
            boolean[] b = new boolean[blacklist.length];
            for(int val : blacklist) {
                if (val >= len) {
                    b[val - len] = true;
                }
            }
            int pos = 0;
            for(int val : blacklist) {
                if (val >= len) {
                    continue;
                }
                while(b[pos]) {
                    pos++;
                }
                map.put(val, len + pos);
                pos++;
            }
        }

        public int pick() {
            int i = r.nextInt(len);
            return map.getOrDefault(i, i);
        }
    }
}
