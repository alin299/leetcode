package top.alin.solution;

public class MaximumXorOfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        Trie trie=new Trie();
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            trie.add(nums[i]);
            max = Math.max(max,trie.findMax(nums[i]));
        }
        return max;
    }

    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }

        public void add(int num) {
            Trie cur = this;
            for(int i = 30; i >= 0; i--) {
                int idx = num >> i & 1;
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie();
                }
                cur = cur.children[idx];
            }
        }

        public int findMax(int num){
            Trie cur = this;
            int res = 0;
            for(int i = 30; i >= 0; i--) {
                int idx = (num >> i & 1) ^ 1;
                if (cur.children[idx] != null) {
                    res |= (1 << i);
                } else {
                    idx ^= 1;
                }
                cur = cur.children[idx];
            }
            return res;
        }
    }
}

