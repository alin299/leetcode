package top.alin.solution;

public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int left = (int)Math.pow(10, n) - 1;
        int ans = 0;
        for(int i = left; ans == 0; i--) {
            long p = i;
            for(int j = i; j > 0; j /= 10) {
                p = p * 10 + j % 10;
            }
            for(long j = left; j * j >= p; j--) {
                if (p % j == 0) {
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
