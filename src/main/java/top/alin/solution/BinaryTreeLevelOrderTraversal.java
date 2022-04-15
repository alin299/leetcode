package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            level = new ArrayList<>(size);
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                level.add(node.val);
            }
            ans.add(level);
        }
        return ans;
    }
}
