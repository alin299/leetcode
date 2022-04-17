package top.alin.solution;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cnt = 1;

                while (set.contains(num + 1)) {
                    num += 1;
                    cnt += 1;
                }

                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}
