package top.alin.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; ++i) {
            if (!map.containsKey(list2[i])) {
                continue;
            }
            int sum = i + map.get(list2[i]);
            if (sum < min) {
                ans.clear();
                ans.add(list2[i]);
                min = sum;
            } else if (sum == min) {
                ans.add(list2[i]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
