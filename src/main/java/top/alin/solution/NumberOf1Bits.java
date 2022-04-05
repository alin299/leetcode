package top.alin.solution;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0) {
            ans ++;
            n &= (n - 1);
        }
        return ans;
    }
}
