package top.alin.solution;

import top.alin.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBst {
    public class Codec {
        int curr;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> result = new ArrayList<>();
            dfs(root, result);
            return String.join(",", result);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            curr = 0;
            return rebuild(arr);
        }

        TreeNode rebuild(String[] arr) {
            if ("null".equals(arr[curr])) {
                curr++;
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(arr[curr++]));
            root.left = rebuild(arr);
            root.right = rebuild(arr);
            return root;
        }

        void dfs(TreeNode root, List<String> list) {
            if (root == null) {
                list.add("null");
                return;
            }
            list.add(String.valueOf(root.val));
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}
