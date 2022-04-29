package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        int i = map.get(head.val);
        int k = i - l2;
        head.left = dfs(preorder, inorder, l1 + 1, l1 + k, l2, i - 1);
        head.right = dfs(preorder, inorder, l1 + k +1, r1, i + 1, r2);
        return head;
    }
}
