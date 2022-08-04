package top.alin.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int cur = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            cur += nums[i];
            if (sum - cur < cur) {
                break;
            }
        }
        return ans;
    }
}
