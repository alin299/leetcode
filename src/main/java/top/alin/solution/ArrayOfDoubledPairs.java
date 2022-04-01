package top.alin.solution;

import java.util.*;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        List<Integer> keys = new ArrayList<Integer>(cnt.keySet());
        Collections.sort(keys, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : keys) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) {
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }
}
