package top.alin.solution;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                ++left;
            } else {
                --right;
            }
        }
        return left >= letters.length ? letters[0] : letters[left];
    }
}
