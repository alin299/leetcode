package top.alin.solution;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        String ans = "0";

        for(int i = chars2.length - 1; i >= 0; --i) {
            int add = 0;
            int x = chars2[i] - '0';
            StringBuilder res = new StringBuilder();
            for(int j = chars2.length - 1; j  > i; j--) {
                res.append('0');
            }
            for(int j = chars1.length - 1; j >= 0; --j) {
                int y = chars1[j] - '0';
                add = add + x * y;
                res.append(add % 10);
                add /= 10;
            }
            if(add != 0) {res.append(add);}
            ans = add(ans, res.reverse().toString());
            System.out.println(ans);
        }

        return ans;
    }

    public String add(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        while(i >= 0 || j >= 0) {
            int x = (i >= 0 ? num1.charAt(i) : '0') - '0';
            int y = (j >= 0 ? num2.charAt(j) : '0') - '0';
            add = add + x + y;
            res.append(add % 10);
            add /= 10;
            --i;
            --j;
        }
        if(add != 0) {res.append(add);}
        return res.reverse().toString();
    }
}
