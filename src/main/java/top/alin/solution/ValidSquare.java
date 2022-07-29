package top.alin.solution;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{p1, p2, p3, p4};
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 3; i++) {
            for(int j = i + 1; j < 4; j++) {
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                int distance = a*a + b * b;
                if (distance == 0) return false;
                set.add(distance);
            }
        }
        return set.size() == 2;
    }
}
