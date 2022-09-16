package top.alin.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleAreaII {
    public int rectangleArea(int[][] rectangles) {
        int MOD = (int)1e9+7;
        long ans = 0;
        List<Integer> list = new ArrayList<>();
        for(int[] item : rectangles) {
            list.add(item[0]);
            list.add(item[2]);
        }
        Collections.sort(list);

        for(int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1);
            int b = list.get(i);
            int len = b - a;
            if (len == 0) {
                continue;
            }
            List<int[]> lines = new ArrayList<>();
            for(int[] item : rectangles) {
                if (item[0] <= a && b <= item[2]) {
                    lines.add(new int[]{item[1], item[3]});
                }
            }
            Collections.sort(lines, (c, d) -> c[0] != d[0] ? c[0] - d[0] : c[1] - d[1]);
            long sum = 0, l = -1, h = -1;
            for(int[] cur : lines) {
                if (cur[0] > h) {
                    sum += (h - l);
                    l = cur[0];
                    h = cur[1];
                } else if (cur[1] > h) {
                    h = cur[1];
                }
            }
            sum += (h - l);
            ans += (sum * len);
            ans %= MOD;
        }
        return (int)ans;
    }
}
