package top.alin.solution;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left < right) {
            while(left < chars.length && !Character.isLetter(chars[left])) {
                left++;
            }
            while(right >= 0 && !Character.isLetter(chars[right])) {
                right--;
            }
            if(left >= right) {break;}
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }
}
