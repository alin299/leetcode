package top.alin.solution;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int lastI = -1;
        for(int i = 0; i < chars.length; ++i) {
            if(chars[i] != ' ') {continue;}
            reverse(chars, lastI + 1, i - 1);
            lastI = i;
        }
        if(lastI != n - 1) {
            reverse(chars, lastI + 1, n - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
