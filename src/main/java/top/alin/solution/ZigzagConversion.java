package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows; ++i) {
            list.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();
        int row = 0, d = -1;
        for(char c : chars) {
            list.get(row).append(c);
            if(row == 0 || row == numRows - 1) {
                d = -d;
            }
            row += d;
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder res : list) {
            ans.append(res);
        }

        return ans.toString();

    }
}
