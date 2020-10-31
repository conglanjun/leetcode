package leetcode.problem867;

public class Transpose {

    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) return null;
        int row = A.length;
        int col = A[0].length;
        int[][] B = new int[col][row];
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }

}
