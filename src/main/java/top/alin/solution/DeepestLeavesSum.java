package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while(!q.isEmpty()) {
            ans = 0;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                ans += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return ans;
    }
}
