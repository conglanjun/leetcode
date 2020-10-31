package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer07BTree1 {

    Map<Integer, Integer> dict = new HashMap<>();
    int[] po;
    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode1 buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        po = preorder;
        for (int i = 0; i < inorder.length; ++i) {
            dict.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode1 recur(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        int inRoot = dict.get(po[preRoot]);
        TreeNode1 t = new TreeNode1(po[preRoot]);
        t.left = recur(preRoot + 1, inLeft, inRoot - 1);
        t.right = recur(preRoot + 1 + inRoot - inLeft, inRoot + 1, inRight - 1);
        return t;
    }

}

class TreeNode1{
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int val) {
        this.val = val;
    }
}
