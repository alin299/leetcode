package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        long nn = Long.parseLong(n);
        List<Long> candidates = getCandidates(n);
        long ans = -1;
        for (Long candidate : candidates) {
            if (candidate == nn) {
                continue;
            }
            if (ans == -1 || Math.abs(nn - candidate) < Math.abs(nn - ans) ||
                    (Math.abs(nn - candidate) == Math.abs(nn - ans) && candidate < ans)) {
                ans = candidate;
            }
        }
        return String.valueOf(ans);
    }

    public List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> res = new ArrayList<Long>(){{
            add((long) (Math.pow(10, len - 1) - 1));
            add((long)(Math.pow(10, len) + 1));
        }};
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for(long i = prefix - 1; i <= prefix + 1; ++i) {
            StringBuilder sb = new StringBuilder();
            String s = String.valueOf(i);
            sb.append(s);
            String suffix = new StringBuilder(sb).reverse().toString();
            if ((len & 1) == 1) {
                sb.append(suffix.substring(1));
            } else {
                sb.append(suffix);
            }
            res.add(Long.parseLong(sb.toString()));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("99"));
    }
}
