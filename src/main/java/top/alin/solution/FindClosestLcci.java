package top.alin.solution;

public class FindClosestLcci {
    public int findClosest(String[] words, String word1, String word2) {
        int ans = words.length;
        int p = -1, q = -1;
        for(int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p = i;
            }  else if (words[i].equals(word2)) {
                q = i;
            }
            if (p != -1 && q != -1) {
                ans = Math.min(ans, Math.abs(p - q));
                if (ans == 1) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
