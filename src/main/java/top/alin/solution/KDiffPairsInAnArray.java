package top.alin.solution;

import java.util.Arrays;

public class KDiffPairsInAnArray {
    class Solution {
        public int findPairs(int[] nums, int k) {
            Arrays.sort(nums);
            int ans = 0;
            for(int i = 0, j = 0; j < nums.length; j++) {
                while(i < j && nums[j] - nums[i] >= k) {
                    if ((i == 0 || nums[i] != nums[i - 1]) && nums[j] - nums[i] == k) {
                        ans++;
                    }
                    i++;
                }
            }
            return ans;
        }
    }
}
