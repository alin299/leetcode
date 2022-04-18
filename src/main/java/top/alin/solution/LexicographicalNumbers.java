package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new ArrayList<>();
            int num = 1;
            for(int i = 0; i < n; i++) {
                ans.add(num);
                if (num * 10 <= n) {
                    num *= 10;
                } else {
                    while(num % 10 == 9 || num + 1 > n) {
                        num /= 10;
                    }
                    num++;
                }
            }

            return ans;
        }
    }
    class Solution2 {
        List<Integer> ans;
        public List<Integer> lexicalOrder(int n) {
            ans = new ArrayList<>();
            dfs(0, n);
            return ans;
        }

        void dfs(int cur, int n) {
            cur *= 10;
            for(int i = 0; i <= 9; i++) {
                cur += i;
                if (cur == 0) {
                    continue;
                } else if (cur <= n) {
                    ans.add(cur);
                    dfs(cur, n);
                    cur -= i;
                } else {
                    break;
                }
            }
        }
    }
}
