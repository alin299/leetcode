package top.alin.solution;

public class RangeSumQueryMutable {
    class NumArray {
        int[] tree;
        int n;
        public NumArray(int[] nums) {
            n = nums.length;
            tree = new int[n * 4];
            build(0, 0, nums.length - 1, nums);
        }

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        public int sumRange(int left, int right) {
            return sumRange(0, 0, n - 1, left, right);
        }

        public void build(int node, int start, int end, int[] nums) {
            if (start == end) {
                tree[node] = nums[start];
                return;
            }
            int mid = start + (end - start) / 2;
            build(node * 2 + 1, start, mid, nums);
            build(node * 2 + 2, mid + 1, end, nums);
            tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
        }

        void update(int node, int start, int end, int index, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (index > mid) {
                update(node * 2 + 2, mid + 1, end, index, val);
            } else {
                update(node * 2 + 1, start, mid, index, val);
            }
            tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
        }

        int sumRange(int node, int start, int end, int left, int right) {
            if (start == left && end == right) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            if (right <= mid) {
                return sumRange(node * 2 + 1, start, mid, left, right);
            } else if (left > mid) {
                return sumRange(node * 2 + 2, mid + 1, end, left, right);
            } else {
                return sumRange(node * 2 + 1, start, mid, left, mid) + sumRange(node * 2 + 2, mid + 1, end, mid + 1, right);
            }
        }

    }
}
