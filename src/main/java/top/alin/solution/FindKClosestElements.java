package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int count = n - k;
        int left, right;
        for(left = 0, right = n - 1; count > 0; count--) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            ans.add(arr[left + i]);
        }
        return ans;
    }
}
