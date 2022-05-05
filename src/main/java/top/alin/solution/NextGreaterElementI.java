package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                int peek = stack.pop();
                map.put(peek, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
