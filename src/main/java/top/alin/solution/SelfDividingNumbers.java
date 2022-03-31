package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (check(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean check(int num) {
        int x = num;
        while(x > 0) {
            if (x % 10 == 0) {
                return false;
            }
            if (num % (x % 10) != 0) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
}
