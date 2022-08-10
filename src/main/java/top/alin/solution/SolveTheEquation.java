package top.alin.solution;

public class SolveTheEquation {
    public String solveEquation(String equation) {
        int factor = 0, val  = 0;
        int i = 0, sign1 = 1, n = equation.length();
        char[] cs = equation.toCharArray();
        while(i < n) {
            if (cs[i] == '=') {
                sign1 = -1;
                i++;
                continue;
            }

            int sign2 = sign1;
            if (cs[i] == '-' || cs[i] == '+') {
                sign2 = cs[i] == '-' ? -sign1 : sign1;
                i++;
            }

            int num = 0;
            boolean valid = false;
            while(i < n && Character.isDigit(cs[i])) {
                num = num * 10 + (cs[i] - '0');
                i++;
                valid = true;
            }

            if (i < n && cs[i] == 'x') {
                factor += valid ? sign2 * num : sign2;
                i++;
            } else {
                val += sign2 * num;
            }
        }

        if (factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }

        if (val % factor != 0) return "No solution";

        return "x=" + (-val / factor);
    }
}
