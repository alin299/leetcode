package top.alin.solution;

import java.util.Arrays;

public class StickersToSpellWord {
    String target;
    String[] stickers;
    int[] memo;
    int INF = 60;
    public int minStickers(String[] stickers, String target) {
        this.target = target;
        this.stickers = stickers;
        memo = new int[1 << target.length()];
        Arrays.fill(memo, -1);
        int ans = dfs(0);
        return ans < INF ? ans : -1;
    }

    int dfs(int state) {
        int n = target.length();
        if (state == (1 << n) - 1) {
            return 0;
        }
        if (memo[state] != -1) {
            return memo[state];
        }
        int step = INF;
        for(String s : stickers) {
            int nextState = state;
            out: for (char c : s.toCharArray()) {
                for (int i = 0; i < n; i++) {
                    if (target.charAt(i) == c && ((nextState >> i) & 1) == 0) {
                        nextState |= (1 << i);
                        continue out;
                    }
                }
            }
            if (nextState != state) {
                step = Math.min(step, dfs(nextState) + 1);
            }
        }
        memo[state] = step;
        return step;
    }
}
