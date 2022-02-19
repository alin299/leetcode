package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for(int i = arr.length - 1; i > 0; --i) {
            int maxIndex = 0;
            for(int j = 0; j <= i; ++j) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if(maxIndex == i) {
                continue;
            }
            ans.add(maxIndex + 1);
            ans.add(i + 1);
            reverse(arr, maxIndex);
            reverse(arr, i);

        }
        return ans;
    }

    public void reverse(int[] arr, int end) {
        for(int i = 0; i < end; i++, end--) {
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
        }

    }
}
