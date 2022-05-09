package top.alin.solution;

public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int min = 0;
        int max = n;
        for(int i = 0; i < n; i++) {
            ans[i] = s.charAt(i) == 'I' ? min++ : max--;
        }
        ans[n] = max;
        return ans;
    }
}
