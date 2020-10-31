package leetcode.problem102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT {

    // BFS
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            List<Integer> level = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; ++i) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(level);
//        }
//        return res;
//    }

    //DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        res.add(level);
        _dpf(root, res, 0);
        return res;
    }

    private void _dpf(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        _dpf(root.left, res, level + 1);
        _dpf(root.right, res, level + 1);
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}