package top.alin.solution;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> item : map.entrySet()) {
            if(item.getValue() == 1) {
                ans += item.getKey();
            }
        }
        return ans;
    }
}
