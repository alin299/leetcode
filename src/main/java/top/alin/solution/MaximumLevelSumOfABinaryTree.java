package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1, level = 1, max = root.val;
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            while(size-- > 0) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (sum > max) {
                max = sum;
                level = i;
            }
            i++;
        }
        return level;
    }
}
