package top.alin.solution;

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] arr = new int[] {2, 3, 5};
        for(int num : arr) {
            while(n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }
}
