package top.alin.solution;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n];
        if (k == 0) {
            return arr;
        }
        int e = k > 0 ? 1 : -1;
        for(int i = 0; i < n; i++) {
            for(int j = e; j != k + e; j += e) {
                arr[i] += code[(i + j + n) % n];
            }
        }
        return arr;
    }
}
