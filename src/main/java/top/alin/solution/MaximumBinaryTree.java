package top.alin.solution;

import top.alin.common.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int idx = start;
        for(int i = start; i <= end; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = build(nums, start, idx - 1);
        root.right = build(nums, idx + 1, end);

        return root;
    }
}
