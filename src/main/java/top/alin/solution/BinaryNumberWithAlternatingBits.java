package top.alin.solution;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int m = n ^ (n >> 1);
        return (m & (m + 1)) == 0;
    }
}
