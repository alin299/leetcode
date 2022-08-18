package top.alin.solution;

import java.util.HashMap;
import java.util.Map;

public class MaximumEqualFrequency {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0, ans = 0;
        for(int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            if (count.getOrDefault(num, 0) > 0) {
                freq.put(count.get(num), freq.get(count.get(num)) - 1);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
            max = Math.max(count.get(num), max);
            freq.put(count.get(num), freq.getOrDefault(count.get(num), 0) + 1);
            boolean valid = max == 1 ||
                    ((freq.get(max) * max + freq.get(max - 1) * (max - 1) == i) && (freq.get(max) == 1)) ||
                    ((freq.get(max) * max + 1 == i) && (freq.get(1) == 1));
            if (valid) {
                ans = Math.max(i, ans);
            }
        }
        return ans;
    }
}
