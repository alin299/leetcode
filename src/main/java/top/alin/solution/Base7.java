package top.alin.solution;

public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (flag) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
