package top.alin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = arr[arr.length - 1] - arr[0];
        for(int i = 0; i < arr.length - 1; i++) {
            int d = arr[i + 1] - arr[i];
            if (d < min) {
                ans.clear();
                min = d;
            }
            if (d == min) {
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return ans;
    }
}
