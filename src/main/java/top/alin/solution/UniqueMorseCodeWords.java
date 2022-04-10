package top.alin.solution;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    String[] dict = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            char[] chars = s.toCharArray();
            StringBuilder code = new StringBuilder();
            for (char c : chars) {
                code.append(dict[c - 'a']);
            }
            set.add(code.toString());
        }
        return set.size();
    }
}
