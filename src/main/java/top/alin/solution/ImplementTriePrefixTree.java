package top.alin.solution;

public class ImplementTriePrefixTree {
    class Trie {
        Trie[] children;
        boolean isEnd;
        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie cur  = this;
            for(char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie();
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
        }

        public Trie searchPrefix(String prefix) {
            Trie cur  = this;
            for(char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    return null;
                }
                cur = cur.children[idx];
            }
            return cur;
        }

        public boolean search(String word) {
            Trie t  = searchPrefix(word);
            return t != null && t.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie t  = searchPrefix(prefix);
            return t != null;
        }
    }

}
