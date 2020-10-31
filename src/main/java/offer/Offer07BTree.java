package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer07BTree {

    Map<Integer, Integer> dict = new HashMap<>();
    int[] po;
    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; ++i) {
            dict.put(inorder[i], i);
        }
        return createTree(0, 0, inorder.length - 1);
    }

    public TreeNode createTree(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        TreeNode t = new TreeNode(po[preRoot]);
        int inRoot = dict.get(po[preRoot]);
        t.left = createTree(preRoot + 1, inLeft, inRoot - 1);
        t.right = createTree(preRoot + 1 + inRoot - inLeft, inRoot + 1, inRight);
        return t;
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
}