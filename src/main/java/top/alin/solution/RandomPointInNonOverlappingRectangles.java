package top.alin.solution;

import java.util.Random;

public class RandomPointInNonOverlappingRectangles {
    class Solution {
        int[] arr;
        int[][] rects;
        Random r;
        public Solution(int[][] rects) {
            arr = new int[rects.length + 1];
            this.rects = rects;
            r = new Random();
            for(int i = 0; i < rects.length; i++) {
                arr[i + 1] = arr[i] + (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            }
        }

        public int[] pick() {
            int num = r.nextInt(arr[arr.length - 1]) + 1;
            int left = 1;
            int right = arr.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int[] rect = rects[left - 1];
            int x = r.nextInt(rect[2] - rect[0] + 1) + rect[0];
            int y = r.nextInt(rect[3] - rect[1] + 1) + rect[1];
            return new int[]{x, y};
        }
    }
}
