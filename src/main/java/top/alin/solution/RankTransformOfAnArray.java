package top.alin.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = Arrays.copyOf(arr, arr.length);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(ans);
        int i = 1;
        for(int num : ans) {
            if (!map.containsKey(num)) {
                map.put(num, i);
                i++;
            }
        }
        for(i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
