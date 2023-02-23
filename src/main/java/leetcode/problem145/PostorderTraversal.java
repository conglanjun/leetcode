package leetcode.problem145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.add(node);
            if (node.left != null) {
                stack1.add(node.left);
            }
            if (node.right != null) {
                stack1.add(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
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
