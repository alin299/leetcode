package top.alin.solution;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 0, b = 0, c = 1;
        for(int i = 1; i <= n; ++i) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
