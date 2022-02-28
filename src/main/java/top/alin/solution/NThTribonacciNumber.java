package top.alin.solution;

public class NThTribonacciNumber {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        n -= 2;
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;
        while (n-- > 0) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
