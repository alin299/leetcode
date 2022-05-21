package top.alin.solution;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2nArray {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
