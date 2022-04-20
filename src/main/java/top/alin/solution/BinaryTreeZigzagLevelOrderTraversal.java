package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isOrderLeft  = true;
        List<Integer> level;
        while(!q.isEmpty()) {
            level = new LinkedList<>();
            int size =  q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (isOrderLeft) {
                    level.add(curr.val);
                } else {
                    level.add(0, curr.val);
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            isOrderLeft = !isOrderLeft;
            ans.add(level);
        }
        return ans;
    }
}
