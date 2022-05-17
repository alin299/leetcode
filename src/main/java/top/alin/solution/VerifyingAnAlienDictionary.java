package top.alin.solution;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for(int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for(int i = 1; i < words.length; i++) {
            boolean valid = false;
            for(int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int p = index[words[i - 1].charAt(j) - 'a'];
                int c = index[words[i].charAt(j) - 'a'];
                if (p < c) {
                    valid = true;
                    break;
                } else if (p > c) {
                    return false;
                }
            }
            if (!valid && words[i - 1].length() > words[i].length()) {
                return false;
            }
        }
        return true;
    }
}
