package top.alin.solution;

public class OneAwayLcci {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        if (Math.abs(n - m) > 1) {
            return false;
        }
        if (m > n) {
            return oneEditAway(second, first);
        }
        int count = 0;
        int i = 0, j = 0;
        while(i < m && j < n && count <= 1) {
            if (first.charAt(i) != second.charAt(j)) {
                if (m < n) {
                    j++;
                    count++;
                } else {
                    i++;
                    j++;
                    count++;
                }
            } else {
                i++;
                j++;
            }
        }
        return count <= 1;
    }
}
