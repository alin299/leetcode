package top.alin.solution;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});
        }
        Collections.sort(list, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        int[] ans = new int[n];
        int idx = 0;
        for (int[] item : list) {
            int a = item[0], b = item[1];
            while (b-- > 0) {
                ans[idx++] = a;
            }
        }
        return ans;
    }
}
