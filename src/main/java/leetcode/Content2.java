package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Content2 {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueback = new LinkedList<>();
        List<List<Integer>> tree = new ArrayList<>();
        TreeNode p = root;
        queue.add(p);
        while (true) {
            List<Integer> li = new ArrayList<>();
            queue.addAll(queueback);
            queueback.clear();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll == null) continue;
                li.add(poll.val);
                queueback.add(poll.left);
                queueback.add(poll.right);
            }
            if (li.size() > 0) {
                tree.add(li);
            } else {
                break;
            }
        }
        for (int i = 0; i < tree.size(); ++i) {
            List<Integer> nodes = tree.get(i);
            if (i % 2 == 0) {
                int val = nodes.get(0);
                if (val % 2 == 0) return false;
                for (int j = 1; j < nodes.size(); ++j) {
                    if (nodes.get(j) < val || nodes.get(j) == val || nodes.get(j) % 2 == 0) {
                        return false;
                    }
                    val = nodes.get(j);
                }
            } else {
                int val = nodes.get(0);
                if (val % 2 == 1) return false;
                for (int j = 1; j < nodes.size(); ++j) {
                    if (nodes.get(j) > val || nodes.get(j) == val || nodes.get(j) % 2 == 1) {
                        return false;
                    }
                    val = nodes.get(j);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l10 = new TreeNode(10);
        TreeNode l11 = new TreeNode(4);
        root.left = l10;
        root.right = l11;
        TreeNode l20 = new TreeNode(3);
        TreeNode l21 = null;
        l10.left = l20;
        l10.right = l21;
        TreeNode l22 = new TreeNode(7);
        TreeNode l23 = new TreeNode(9);
        l11.left = l22;
        l11.right = l23;
        Content2 c = new Content2();
        c.isEvenOddTree(root);
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}