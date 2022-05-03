package top.alin.solution;

import java.util.Arrays;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            int index1 = a.indexOf(' ') + 1;
            int index2 = b.indexOf(' ') + 1;
            if (Character.isDigit(a.charAt(index1)) && Character.isDigit(b.charAt(index2))) {
                return 0;
            } else if (Character.isDigit(a.charAt(index1))) {
                return 1;
            } else if (Character.isDigit(b.charAt(index2))) {
                return -1;
            } else {
                String s1 = a.substring(index1);
                String s2 = b.substring(index2);
                int res = s1.compareTo(s2);
                return res == 0 ? a.compareTo(b) : res;
            }
        });
        return logs;
    }
}
