package top.alin.solution;

public class BinaryGap {
    public int binaryGap(int n) {
        int ans = 0;
        int pre = -1;
        int i = 0;
        while(n > 0) {
            if ((n & 1) == 1) {
                if (pre != -1) {
                    ans = Math.max(ans, i - pre);
                }
                pre = i;
            }
            i++;
            n >>= 1;
        }
        return ans;
    }
}
