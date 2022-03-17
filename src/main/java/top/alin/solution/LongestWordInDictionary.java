package top.alin.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public String longestWord1(String[] words) {
        String ans = "";
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        Set<String> set = new HashSet<>();
        set.add("");
        for(String s : words) {
            if(set.contains(s.substring(0, s.length() - 1))) {
                set.add(s);
                ans = s;
            }
        }
        return ans;
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String s : words) {
            trie.insert(s);
        }
        String ans = "";
        int maxLen = 0;
        for (String s : words) {
            if (trie.search(s)) {
                int len = s.length();
                if (len > maxLen || (len == maxLen && s.compareTo(ans) < 0)) {
                    ans = s;
                    maxLen = len;
                }
            }
        }
        return ans;
    }
}



class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for(char c : chars) {
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Trie();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for(char c : chars) {
            node = node.children[c - 'a'];
            if(node == null || !node.isEnd) {
                return false;
            }
        }
        return true;
    }
}
