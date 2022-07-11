package top.alin.solution;

public class ImplementMagicDictionary {
    Trie root;
    public ImplementMagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            Trie cur = root;
            for(char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie();
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        return search(searchWord, 0, 1, root);
    }

    public boolean search(String searchWord, int pos, int count, Trie cur) {
        if (pos == searchWord.length()) {
            return count == 0 && cur.isEnd;
        }
        int idx = searchWord.charAt(pos) - 'a';
        for(int i = 0; i < 26; i++) {
            if (cur.children[i] == null) {
                continue;
            }
            int c = i == idx ? count : count - 1;
            if (c >= 0 && search(searchWord, pos + 1, c, cur.children[i])) {
                return true;
            }
        }
        return false;
    }

    class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }
}
