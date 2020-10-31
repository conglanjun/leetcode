package leetcode.problem437;

import java.util.LinkedList;

public class PathSumIII {

    private int pathCount = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pollLast();
            if (curNode.left != null) {
                stack.add(curNode.left);
            }
            if (curNode.right != null) {
                stack.add(curNode.right);
            }
            calSum(curNode, sum);
        }
        return pathCount;
    }

    public void calSum(TreeNode root, int sum) {
        if (root == null) return;
        if (sum == root.val) ++pathCount;
        calSum(root.left, sum - root.val);
        calSum(root.right, sum - root.val);
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