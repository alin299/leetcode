package top.alin.solution;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            // 665772 = (1 << 2) | (1 << 3) | (1 << 5) | (1 << 7) | (1 << 11) | (1 << 13) | (1 << 17) | (1 << 19)
            if (((1 << bitCount(i)) & 665772) != 0) {
                ans++;
            }
        }
        return ans;
    }

    public int bitCount(int num) {
        int count = 0;
        while(num != 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

}
