package top.alin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErectTheFence {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[n];
        list.add(0);
        for (int i = 1; i < n; i++) {
            while (list.size() > 1 && cross(trees[list.get(list.size() - 2)], trees[list.get(list.size() - 1)], trees[i]) > 0) {
                used[list.get(list.size() - 1)] = false;
                list.remove(list.size() - 1);
            }
            used[i] = true;
            list.add(i);
        }
        int m = list.size();
        for (int i = n - 2; i >= 0; i--) {
            if (!used[i]) {
                while(list.size() > m
                        && cross(trees[list.get(list.size() - 2)], trees[list.get(list.size() - 1)], trees[i]) > 0) {
                    used[list.get(list.size() - 1)] = false;
                    list.remove(list.size() - 1);
                }
                used[i] = true;
                list.add(i);
            }
        }
        list.remove(list.size() - 1);
        int size = list.size();
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            ans[i] = trees[list.get(i)];
        }
        return ans;
    }

    public int cross(int[] a, int[] b, int[] c) {
        return (c[1] - a[1]) * (b[0] - a[0]) - (b[1] - a[1]) * (c[0] - a[0]);
    }
}
