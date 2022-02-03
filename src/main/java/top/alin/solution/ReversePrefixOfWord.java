package top.alin.solution;

public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        char[] chars = word.toCharArray();
        int i = 0;
        for(; i < n; ++i) {
            if(chars[i] == ch) {
                break;
            }
        }
        if(i >= n) {
            return word;
        }
        for(int j = 0; j < i; ++j, --i) {
            char c = chars[j];
            chars[j] = chars[i];
            chars[i] = c;
        }
        return new String(chars);
    }
}
