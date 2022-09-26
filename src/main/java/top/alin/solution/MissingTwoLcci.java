package top.alin.solution;

public class MissingTwoLcci {
    public int[] missingTwo(int[] nums) {
        int x = 0;
        int n = nums.length + 2;
        for(int num : nums) {
            x ^= num;
        }
        for(int i = 1; i <= n; i++) {
            x ^= i;
        }
        int p = x & (-x);
        int a = 0,  b = 0;
        for(int num : nums) {
            if ((num & p) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for(int i = 1; i <= n; i++) {
            if ((i & p) != 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
