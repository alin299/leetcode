package top.alin.solution;

public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int ans = 0;
        for(int left = 0, right = 0; right < charS.length; right++) {
            maxCost -= Math.abs(charS[right] - charT[right]);
            while (maxCost < 0) {
                maxCost += Math.abs(charS[left] - charT[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
