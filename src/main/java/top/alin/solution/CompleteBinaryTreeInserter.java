package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CompleteBinaryTreeInserter {
    class CBTInserter {
        List<TreeNode> list;
        int idx;

        public CBTInserter(TreeNode root) {
            list = new ArrayList<>();
            idx = 0;
            list.add(root);
            int cur = 0;
            while (cur < list.size()) {
                TreeNode node = list.get(cur);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                cur++;
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            while (list.get(idx).left != null && list.get(idx).right != null) {
                idx++;
            }
            TreeNode p = list.get(idx);
            if (p.left == null) {
                p.left = node;
            } else if (p.right == null) {
                p.right = node;
            }
            list.add(node);
            return p.val;
        }

        public TreeNode get_root() {
            return list.get(0);
        }
    }
}
