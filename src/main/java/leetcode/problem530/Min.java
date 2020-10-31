package leetcode.problem530;

public class Min {

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return _dpf(root);
    }

    private int _dpf(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return Integer.MAX_VALUE;
        int lchildMin = _dpf(root.left);
        int rchildMin = _dpf(root.right);
        int min = Math.min(lchildMin, rchildMin);
        TreeNode p = root.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            int leftMin = Math.abs(root.val - p.val);
            if (leftMin < min) {
                min = leftMin;
            }
        }
        p = root.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            int rightMin = Math.abs(root.val - p.val);
            if (rightMin < min) {
                min = rightMin;
            }
        }
        return min;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}