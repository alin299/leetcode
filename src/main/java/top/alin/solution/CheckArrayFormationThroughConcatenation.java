package top.alin.solution;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] p : pieces) {
            map.put(p[0], p);
        }
        int n = arr.length;
        for(int i = 0; i < n;) {
            if(!map.containsKey(arr[i])) {
                return false;
            }
            int[] p = map.get(arr[i]);
            int len = p.length;
            for(int j = 0; j < len; j++) {
                if(arr[i + j] != p[j]) {
                    return false;
                }
            }
            i += len;
        }
        return true;
    }
}
