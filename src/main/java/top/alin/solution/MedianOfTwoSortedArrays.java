package top.alin.solution;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        int k = totalLength + 1 >> 1;
        if ((totalLength & 1) == 1) {
            double median = getKthElement(nums1, nums2, k);
            return median;
        } else {
            double median = (getKthElement(nums1, nums2, k) + getKthElement(nums1, nums2, k + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;

        while (true) {
            if(index1 >= nums1.length) {
                return nums2[index2 + k - 1];
            }
            if(index2 >= nums2.length) {
                return nums1[index1 + k - 1];
            }
            if(k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k >> 1;

            int newIndex1 = Math.min(index1 + half, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + half, nums2.length) - 1;
            if(nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
