package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.*;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
