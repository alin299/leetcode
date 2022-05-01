package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        dfs(root1, q1);
        dfs(root2, q2);
        List<Integer> ans = new ArrayList<>();
        while(!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() < q2.peek()) {
                ans.add(q1.poll());
            } else {
                ans.add(q2.poll());
            }
        }
        while(!q1.isEmpty()) {
            ans.add(q1.poll());
        }
        while(!q2.isEmpty()) {
            ans.add(q2.poll());
        }
        return ans;
    }

    void dfs(TreeNode root, Queue<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
