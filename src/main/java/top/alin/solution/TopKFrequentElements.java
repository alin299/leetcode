package top.alin.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer>  map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(Integer num : map.keySet()) {
            q.offer(num);
        }
        int[] ans = new int[k];
        int i = 0;
        while(i < k) {
            ans[i++] = q.poll();
        }
        return ans;
    }
}
