package top.alin.solution;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        String[] complex1 = num1.split("\\+|i");
        String[] complex2 = num2.split("\\+|i");
        int real1 = Integer.parseInt(complex1[0]);
        int real2 = Integer.parseInt(complex2[0]);
        int imag1 = Integer.parseInt(complex1[1]);
        int imag2 = Integer.parseInt(complex2[1]);
        int real = real1 * real2 - imag1 * imag2;
        int imag = real1 * imag2 + real2 * imag1;
        String ans = String.format("%d+%di", real, imag);
        return ans;
    }
}
