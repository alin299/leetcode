package top.alin.solution;

public class RotatedDigits {
    public int rotatedDigits(int n) {
        int ans = 0;
        out:for(int i = 0; i <= n; i++) {
            int x = i;
            boolean flag = false;
            while(x != 0) {
                int t = x % 10;
                x /= 10;
                if (t == 2 || t == 5 || t == 6 || t == 9) {
                    flag = true;
                } else if (t != 0 && t != 1 && t != 8) {
                    continue out;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}
