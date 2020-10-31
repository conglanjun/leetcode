package leetcode.problem572;

public class Subtree {

    public boolean findSame = false;
    public boolean finalSame = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        findSubtree(s, t);
        return finalSame;
    }

    public void findSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            if (findSame) {
                finalSame = true;
            }
            return;
        }
        if (s == null || t == null) {
            findSame = false;
            return;
        }
        if (s.val == t.val) {
            findSame = true;
            findSubtree(s.left, t.left);
            findSubtree(s.right, t.right);
        } else {
            findSame = false;
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