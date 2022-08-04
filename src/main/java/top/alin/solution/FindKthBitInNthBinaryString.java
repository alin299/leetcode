package top.alin.solution;

public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            return invert(findKthBit(n - 1, mid * 2 - k));
        }
    }

    char invert(char c) {
        return c == '0' ? '1' : '0';
    }
}
