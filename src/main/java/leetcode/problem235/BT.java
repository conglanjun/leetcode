package leetcode.problem235;

public class BT {

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || (root.left == null && root.right == null) || root == p || root == q) return root;
//        if (root.val > p.val && root.val > q.val) {
//            return lowestCommonAncestor(root.left, p, q);
//        } else if (root.val < p.val && root.val < q.val) {
//            return lowestCommonAncestor(root.right, p, q);
//        } else {
//            return root;
//        }
//    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q) return root;
//        return (root.val > p.val && root.val > q.val) ? lowestCommonAncestor(root.left, p, q) : (root.val < p.val && root.val < q.val) ? lowestCommonAncestor(root.right, p, q) : root;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ this.val = x; }
}