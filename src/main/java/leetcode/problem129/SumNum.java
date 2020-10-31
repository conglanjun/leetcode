package leetcode.problem129;

import java.util.ArrayList;
import java.util.List;

public class SumNum {

    public int sumNumbers(TreeNode root) {
        List<String> dps = dps(root);
        int sum = 0;
        for (int i = 0; i < dps.size(); ++i) {
            sum += Integer.parseInt(dps.get(i));
        }
        return sum;
    }

    private List<String> dps(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<String> ls = dps(root.left);
        for (int i = 0; i < ls.size(); ++i) {
            String s = root.val + ls.get(i);
            res.add(s);
        }
        List<String> rs = dps(root.right);
        for (int i = 0; i < rs.size(); ++i) {
            String s = root.val + rs.get(i);
            res.add(s);
        }
        if (ls.isEmpty() && rs.isEmpty()) {
            res.add(String.valueOf(root.val));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SumNum s = new SumNum();
        int i = s.sumNumbers(root);
        System.out.println(i);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}