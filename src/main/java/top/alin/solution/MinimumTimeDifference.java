package top.alin.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for(String s : timePoints) {
            String[] ss = s.split(":");
            Integer num = Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
            if(list.contains(num)) {
                return 0;
            } else {
                list.add(num);
                list.add(num + 24 * 60);
            }
        }
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        min = Math.min(min, Math.abs(list.get(0) - list.get(list.size() - 1)));
        for(int i = 1; i < list.size(); ++i) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return min;
    }
}
