package top.alin.solution;

public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        for(int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for(int j = 0; j < strs.length; j++) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int p = 0, k = 0;
        while(p < s.length() && k < t.length()) {
            if (s.charAt(p) == t.charAt(k)) {
                p++;
            }
            k++;
        }
        return p == s.length();
    }
}
