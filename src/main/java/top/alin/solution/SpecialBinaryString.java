package top.alin.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpecialBinaryString {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) {
            return "";
        }

        List<String> list = new ArrayList<>();
        int count = 0, start = 0;
        for(int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == '1' ? 1 : -1);
            if (count == 0) {
                String str = "1" + makeLargestSpecial(s.substring(start + 1, i)) + "0";
                list.add(str);
                start = i + 1;
            }
        }

        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
