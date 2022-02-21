package top.alin.solution;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int n = chars.length;
        char start = 'L';
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && chars[j] == '.') {
                ++j;
            }
            char end = j < n ? chars[j] : 'R';
            if(start == end) {
                while (i < j) {
                    chars[i++] = end;
                }
            } else if (start == 'R' && end == 'L'){
                int k = j - 1;
                while (i < k) {
                    chars[i++] = 'R';
                    chars[k--] = 'L';
                }
            }
            start = end;
            i = j + 1;
        }
        return new String(chars);
    }
}
