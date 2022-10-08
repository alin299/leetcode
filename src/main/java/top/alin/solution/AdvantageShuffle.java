package top.alin.solution;

import java.util.Arrays;
import java.util.Comparator;

public class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] ids = new Integer[n];
        for(int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(ids, Comparator.comparingInt(i -> nums2[i]));
        int left = 0, right = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            if (nums1[right] > nums2[ids[i]]) {
                nums2[ids[i]] = nums1[right--];
            } else {
                nums2[ids[i]] = nums1[left++];
            }
        }
        return nums2;
    }
}
