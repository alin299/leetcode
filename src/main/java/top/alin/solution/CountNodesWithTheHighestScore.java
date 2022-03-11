package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class CountNodesWithTheHighestScore {
    List<Integer>[] children;
    long max;
    int n;
    int ans;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        max = 0;
        ans = 0;
        for(int i = 0; i < n; ++i) {
            children[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; ++i) {
            int p = parents[i];
            if (p == -1) {
                continue;
            }
            children[p].add(i);
        }
        dfs(0);
        return ans;
    }

    public long dfs(int root) {
        long product = 1, sum = 1;
        if (!children[root].isEmpty()) {
            for(int child : children[root]) {
                long num = dfs(child);
                sum += num;
                product *= num;
            }
            product = root == 0 ? product : product * (n - sum);
        } else {
            product = n - 1;
        }
        if (product > max) {
            max = product;
            ans = 1;
        } else if (product == max) {
            ++ans;
        }
        return sum;
    }
}
