package top.alin.solution;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length;
        int idx = n - 1;
        int[] maxIndex = new int[n];
        for(int i = n - 2; i >= 0; i--) {
            if (cs[i] > cs[idx]) {
                idx = i;
            }
            maxIndex[i] = idx;
        }
        for(int i = 0; i < n - 1; i++) {
            if (cs[i] != cs[maxIndex[i]]) {
                char temp = cs[i];
                cs[i] = cs[maxIndex[i]];
                cs[maxIndex[i]] = temp;
                return Integer.parseInt(new String(cs));
            }
        }
        return num;
    }
}
