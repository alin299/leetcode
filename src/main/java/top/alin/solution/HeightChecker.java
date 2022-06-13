package top.alin.solution;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int max = Arrays.stream(heights).max().getAsInt();
        int[] arr = new int[max + 1];
        for(int h : heights) {
            arr[h]++;
        }
        int ans = 0;
        for(int i = 1, j = 0; i <= max; i++) {
            while(arr[i]-- > 0) {
                if (heights[j++] != i) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
