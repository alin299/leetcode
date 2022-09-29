package top.alin.solution;

public class StringRotationLcci {
    public boolean isFlipedString(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) return false;
        if (n == 0) return true;
        for(int i = 0; i < n; i++) {
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                if (s1.charAt((i + j) % n) != s2.charAt((j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
