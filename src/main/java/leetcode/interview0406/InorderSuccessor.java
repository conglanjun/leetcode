package leetcode.interview0406;

import java.util.Stack;

public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (p == pre) {
                return curr;
            }
            pre = curr;
            curr = curr.right;
        }
        return null;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
