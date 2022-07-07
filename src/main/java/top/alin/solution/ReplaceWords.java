package top.alin.solution;

import java.util.List;

public class ReplaceWords {
    Trie root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for(String str : dictionary) {
            Trie cur = root;
            for(int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie();
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
        }
        String[] arr = sentence.split(" ");
        for(int j = 0; j < arr.length; j++) {
            Trie cur = root;
            for(int i = 0; i < arr[j].length(); i++) {
                int idx = arr[j].charAt(i) - 'a';
                cur = cur.children[idx];
                if (cur == null) {
                    break;
                }
                if (cur.isEnd) {
                    arr[j] = arr[j].substring(0, i + 1);
                    break;
                }
            }
        }
        return String.join(" ", arr);
    }

    class Trie {
        public Trie[] children;
        public Boolean isEnd;
        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }
    }
}
