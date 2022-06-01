package top.alin.solution;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int total = Arrays.stream(matchsticks).sum();
        if (total % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        for(int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[j];
            matchsticks[j] = matchsticks[i];
            matchsticks[i] = temp;
        }

        return dfs(0, matchsticks, new int[4], total / 4);
    }

    boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        for(int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
