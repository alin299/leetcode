package top.alin.solution;

public class FibonacciNumber {
    class Solution {
        public int fib(int n) {
            if(n < 2) {
                return n;
            }
            int a = 0;
            int b = 1;
            int c = 0;
            while(n-- > 1) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
