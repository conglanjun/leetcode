package leetcode.problem98;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return validTree(root);
    }

    private boolean validTree(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (!(validTree(root.left) && validTree(root.right))) {
                return false;
            }
            // find left's right children
            TreeNode back = root.left;
            if (root.left != null) {
                while (back.right != null) {
                    back = back.right;
                }
                if (root.val <= back.val) {
                    return false;
                }
            }
            back = root.right;
            if (root.right != null){
                while (back.left != null) {
                    back = back.left;
                }
                if (root.val >= back.val) {
                    return false;
                }
            }
            if (root.left == null && root.right == null){
                return true;
            }
        }
        return true;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ this.val = x; }
}
