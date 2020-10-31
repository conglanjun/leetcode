package leetcode.problem463;

public class Land {

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) continue;
                if (i == 0) sum += 1;
                if (i == grid.length - 1) sum += 1;
                if (j == 0) sum += 1;
                if (j == grid[0].length - 1) sum += 1;
                if (i > 0 && grid[i - 1][j] == 0) {
                    sum += 1;
                }
                if (i < grid.length - 1 && grid[i + 1][j] == 0) {
                    sum += 1;
                }
                if (j > 0 && grid[i][j - 1] == 0) {
                    sum += 1;
                }
                if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a1 = {0,1,0,0};
        int[] a2 = {1,1,1,0};
        int[] a3 = {0,1,0,0};
        int[] a4 = {1,1,0,0};
        int[][] arr = new int[4][4];
        arr[0] = a1;
        arr[1] = a2;
        arr[2] = a3;
        arr[3] = a4;
        Land l = new Land();
        l.islandPerimeter(arr);
    }

}
