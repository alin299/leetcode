package top.alin.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for(int[] account : accounts) {
            int sum = 0;
            for(int num : account) {
                sum += num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
