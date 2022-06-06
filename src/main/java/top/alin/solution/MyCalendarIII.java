package top.alin.solution;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarIII {
    class MyCalendarThree {
        private TreeMap<Integer, Integer> map;
        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int start, int end) {
            int ans = 0;
            int sum = 0;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sum += entry.getValue();
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }
}
