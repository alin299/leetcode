package top.alin.solution;

public class CheckPermutationLcci {
    public boolean CheckPermutation(String s1, String s2) {
        int[] arr = new int[26];
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        for(char c : cs1) {
            arr[c - 'a']++;
        }
        for(char c : cs2) {
            if (--arr[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
