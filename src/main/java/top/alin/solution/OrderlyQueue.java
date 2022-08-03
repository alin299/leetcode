package top.alin.solution;

import java.util.Arrays;

public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            StringBuffer sb = new StringBuffer(s);
            String ans = s;
            for(int i = 0; i < s.length(); i++) {
                sb.deleteCharAt(0);
                sb.append(s.charAt(i));
                String cur = sb.toString();
                if (cur.compareTo(ans) < 0) {
                    ans = cur;
                }
            }
            return ans;
        } else {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}
