package top.alin.solution;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') counts[0]++;
            else if (c == 'a') counts[1]++;
            else if (c == 'l') counts[2]++;
            else if (c == 'o') counts[3]++;
            else if (c == 'n') counts[4]++;
        }
        counts[2] /= 2; counts[3] /= 2;
        int ans = counts[0];
        for (int i = 0; i < 5; i++) {
            ans = Math.min(ans, counts[i]);
        }
        return ans;
    }
}
