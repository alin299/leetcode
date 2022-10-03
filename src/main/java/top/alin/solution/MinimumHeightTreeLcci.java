package top.alin.solution;

import top.alin.common.TreeNode;

public class MinimumHeightTreeLcci {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int m = i + (j - i + 1) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = build(nums, i, m - 1);
        node.right = build(nums, m + 1, j);
        return node;
    }
}
