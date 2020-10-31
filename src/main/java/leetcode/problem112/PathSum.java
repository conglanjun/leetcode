package leetcode.problem112;

public class PathSum {

    public boolean isPathSum = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        depth(root, sum);
        return isPathSum;
    }

    public void depth(TreeNode root, int sum) {
        if (root == null) return;
        depth(root.left, sum - root.val);
        depth(root.right, sum - root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            isPathSum = true;
        }
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
