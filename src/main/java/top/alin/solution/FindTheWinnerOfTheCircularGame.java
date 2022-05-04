package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame {
    class Solution1 {
        public int findTheWinner(int n, int k) {
            List<Integer> list = new ArrayList<>();
            for(int i = 1; i <= n; i++) {
                list.add(i);
            }
            int index = 0;
            while(list.size() > 1) {
                index = (index + k - 1) % list.size();
                list.remove(index);
            }
            return list.get(0);
        }
    }
    class Solution {
        public int findTheWinner(int n, int k) {
            int pos = 0;
            System.out.println(pos);
            for (int i = 2; i <= n; ++i) {
                pos = (pos + k) % i;
            }
            return pos + 1;
        }
    }
}
