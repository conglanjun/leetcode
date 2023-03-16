package leetcode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class demo1 {

    public int getLongest(String str) {
        if (str == null || str.length() == 0) return 0;
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < str.length(); ++i) {
            char c1 = str.charAt(i);
            int j;
            for (j = 0; j < i; ++j) {
                char c2 = str.charAt(j);
                if (c1 == c2) {
                    dp[i] = dp[i - 1];
                    break;
                }
            }
            if (j == i) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
        }
        return dp[str.length() - 1];
    }
//
//    public static void main(String[] args) {
//        demo1 d = new demo1();
//        int abcda = d.getLongest("abcjdkaaa");
//        System.out.println(abcda);
//    }


//    Determine if a 9 x 9 Sudoku board is valid.
//    Only the filled cells need to be validated according to the following rules:
//    1.Each row must contain the digits 1-9 without repetition.
//    2.Each column must contain the digits 1-9 without repetition.
//    3.Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.Note:- A Sudoku board (partially filled) could be valid but is not necessarily solvable.- Only the filled cells need to be validated according to the mentioned rules.Example 1:```Input: board =[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]Output: true```Example 2:```Input: board =[["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]Output: false```Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.Constraints:- board.length == 9- board[i].length == 9- board[i][j] is a digit 1-9 or '.'.```javaclass Solution {​​public boolean isValidSudoku(char[][] board) {​​}​​}​​``````gofunc isValidSudoku(board [][]byte) bool {​​}​​```

    /**
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:1.Each row must contain the digits 1-9 without repetition.2.Each column must contain the digits 1-9 without repetition.3.Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.Note:- A Sudoku board (partially filled) could be valid but is not necessarily solvable.- Only the filled cells need to be validated according to the mentioned rules.Example 1:```Input: board =[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]Output: true```Example 2:```Input: board =[["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]Output: false```Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.Constraints:- board.length == 9- board[i].length == 9- board[i][j] is a digit 1-9 or '.'.```javaclass Solution {​​public boolean isValidSudoku(char[][] board) {​​}​​}​​``````gofunc isValidSudoku(board [][]byte) bool {​​}​​```
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int number = board[i][j] - '0';
                if (rows[i][number] == 1) {
                    return false;
                }
                if (cols[j][number] == 1) {
                    return false;
                }
                if (box[(i / 3) * 3 + (j / 3)][number] == 1) {
                    return false;
                }
                rows[i][number] = 1;
                cols[j][number] = 1;
                box[(j / 3) + (i / 3) * 3][number] = 1;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        demo1 d = new demo1();
//        Map<Integer, Integer> mapCount = d.getMapCount(new String[]{"210112198601253836", "210112199901253836"});
//        System.out.println(mapCount);
//    }

    // identify ids 210112198601253836     10 years   count
    public Map<Integer, Integer> getMapCount(String[] ids) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            res.put(i + 1, 0);
        }
        for (int i = 0; i < ids.length; i++) {
            // 210112198601253836
            String id = ids[i];
            String yearStr = id.substring(6, 10);
            int yearNumber = Integer.parseInt(yearStr);
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            int nowYear = c.get(Calendar.YEAR);
            int key = (nowYear - yearNumber) / 10 + 1;
            res.put(key, res.get(key) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

    }

    class Node {
        Node left;
        Node right;
        int val;
        public Node() {

        }
        public int getVal() {
            return val;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();  // 1(1)           2(3 2)              3(4 5 6 7)
        res.add(level);
        _dpf(root, res, 0);
        return  res;
    }

    private void _dpf(Node root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        _dpf(root.left, res, level + 1);
        _dpf(root.right, res, level + 1);
    }

    // 1
    //  2
   //  4 5































}
