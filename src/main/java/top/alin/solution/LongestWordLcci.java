package top.alin.solution;

import java.util.Arrays;

public class LongestWordLcci {
    Trie root;
    public String longestWord(String[] words) {
        root = new Trie();
        for (String s : words) {
            root.insert(s);
        }
        Arrays.sort(words, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        for (String s : words) {
            if (search(s, 0, 0) > 1) {
                return s;
            }
        }
        return "";
    }

    int search(String s, int start, int size) {
        if (start == s.length()) {
            return size;
        }
        Trie node = root;
        for(int i = start; i < s.length(); i++) {
            node = node.children[s.charAt(i) - 'a'];
            if(node == null) {
                return 0;
            }
            int res;
            if (node.isEnd && (res = search(s, i + 1, size + 1)) > 0) {
                return res;
            }
        }
        return 0;
    }

}
