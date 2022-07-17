package top.alin.solution;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            while(nums[i] < n) {
                count++;
                int num = nums[i];
                nums[i] = n;
                i = num;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
