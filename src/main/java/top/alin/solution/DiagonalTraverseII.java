package top.alin.solution;

import java.util.List;
import java.util.PriorityQueue;

public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) ->{
            if (a[0] + a[1] == b[0] + b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] + a[1] - b[0] - b[1];
            }
        });
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < nums.get(i).size(); j++) {
                q.offer(new int[]{i, j});
            }
        }
        int[] ans = new int[q.size()];
        for(int i = 0; i < ans.length; i++) {
            int[] cur = q.poll();
            ans[i] = nums.get(cur[0]).get(cur[1]);
        }
        return ans;
    }
}
