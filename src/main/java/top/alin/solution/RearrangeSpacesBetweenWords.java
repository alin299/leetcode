package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        int n = text.length(), count = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0, j = 0; j < n;) {
            if (text.charAt(j) != ' ') {
                i = j;
                while(j < n && text.charAt(j) != ' ') {
                    j++;
                }
                list.add(text.substring(i, j));
            } else {
                count++;
                j++;
            }
        }
        StringBuffer sb = new StringBuffer();
        int len = list.size() - 1;
        for(int i = 0; i < len; i++) {
            sb.append(list.get(i));
            for (int j = 0; j < count / len; j++) {
                sb.append(" ");
            }
        }
        sb.append(list.get(len));
        while (sb.length() != n) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
