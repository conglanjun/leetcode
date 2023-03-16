package leetcode.p95AVLII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AVLTreeGeneration {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        // iterate root
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generateTrees(start, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = left;
                    currentNode.right = right;
                    result.add(currentNode);
                }
            }
        }
        return result;
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



    public int problem2(int[] nums) {
        int n = nums.length;
        // get min and max
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }

        // bucket has number ?
        boolean[] hasNumber = new boolean[n + 1];
        // min value in bucket
        int[] bucketLow = new int[n + 1];
        // max value in bucket
        int[] bucketHigh = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int idx = (num - min) * n / (max - min);
            // put min value in the bucket
            bucketLow[idx] = hasNumber[idx] ? Math.min(bucketLow[idx], num) : num;
            // put max value in the bucket
            bucketHigh[idx] = hasNumber[idx] ? Math.max(bucketHigh[idx], num) : num;
            hasNumber[idx] = true;
        }
        int res = 0, lastMax = bucketHigh[0];
        for (int i = 1; i <= n; i++) {
            if (hasNumber[i]) {
                res = Math.max(res, bucketLow[i] - lastMax);
                lastMax = bucketHigh[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode g = new TreeNode();
    }



































}