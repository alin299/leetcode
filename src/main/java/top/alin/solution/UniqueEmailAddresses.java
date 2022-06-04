package top.alin.solution;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuffer sb = new StringBuffer();
            int n = email.length(), i = 0;
            boolean flag = true;
            while (i < n) {
                char c = email.charAt(i);
                if (c == '@') {
                    break;
                } else if (c == '.') {
                    i++;
                    continue;
                } else if (c == '+') {
                    flag = false;
                }
                if (flag) {
                    sb.append(c);
                }
                i++;
            }
            set.add(sb.append(email.substring(i)).toString());
        }
        return set.size();
    }
}
