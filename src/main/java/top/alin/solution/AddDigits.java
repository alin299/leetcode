package top.alin.solution;

public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        while(num >= 10) {
            int next = 0;
            while(num > 0) {
                next += (num % 10);
                num /= 10;
            }
            num = next;
        }
        return num;
    }
}
