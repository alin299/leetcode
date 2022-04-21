package top.alin.solution;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        char[] cs = sentence.toCharArray();
        int n = cs.length;
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n;) {
            int j = i;
            while(j < n && sentence.charAt(j) != ' ') {
                j++;
            }
            count++;
            if (set.contains(cs[i])) {
                ans.append(cs, i, j - i);
            } else {
                ans.append(cs, i + 1, j - i - 1);
                ans.append(cs[i]);
            }
            ans.append("ma");
            for(int k = 0; k < count; k++) {
                ans.append('a');
            }
            if(j < n) {
                ans.append(cs[j]);
            }
            i = j + 1;
        }
        return ans.toString();
    }

}
