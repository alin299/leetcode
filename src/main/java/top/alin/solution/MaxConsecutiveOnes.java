package top.alin.solution;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, cnt = 0;
        for(int num : nums) {
            cnt = num == 1 ? cnt + 1 : 0;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
