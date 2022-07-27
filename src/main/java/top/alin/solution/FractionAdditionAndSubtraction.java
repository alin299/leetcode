package top.alin.solution;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        long a = 0, b = 1;
        int index = 0, n = expression.length();
        while(index < n) {
            long c = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                c = c * 10 + expression.charAt(index) - '0';
                index++;
            }
            c *= sign;
            index++;

            long d = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                d = d * 10 + expression.charAt(index) - '0';
                index++;
            }
            a = a * d + c * b;
            b *= d;
        }

        if (a == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(a), b);
        return Long.toString(a / g) + "/" + Long.toString(b / g);
    }

    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
