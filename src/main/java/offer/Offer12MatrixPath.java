package offer;

public class Offer12MatrixPath {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (bfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, String word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(k)) return false;
        if (k == word.length() - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean bfs = bfs(board, word, i + 1, j, k + 1) || bfs(board, word, i, j + 1, k + 1) ||
                      bfs(board, word, i - 1, j, k + 1) || bfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return bfs;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][];
        board[0] = new char[]{'a', 'b', 'c', 'e'};
        board[1] = new char[]{'s', 'f', 'c', 's'};
        board[2] = new char[]{'a', 'd', 'e', 'e'};
        Offer12MatrixPath o = new Offer12MatrixPath();
        boolean res = o.exist(board, "bfce");
        System.out.println(res);
    }

}