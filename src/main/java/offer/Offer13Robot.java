package offer;

import java.util.LinkedList;
import java.util.Queue;

public class Offer13Robot {

    int m, n, k;
    boolean[][] visited;
    public int movingCount1(int m, int n, int k) {
        this.visited =new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k =k;
        return dfs(0, 0, 0, 0);
    }
    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0? si + 1: si -8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0? sj + 1: sj - 8);
    }

    public int movingCount(int m, int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1], si =poll[2], sj = poll[3];
            if (i >=m || j >= n || si + sj > k || visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0? si + 1: si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0? sj + 1: sj - 8});
        }
        return res;
    }

    public static void main(String[] args) {
        Offer13Robot o = new Offer13Robot();
        int i = o.movingCount(16, 8, 4);
        System.out.println(i);
    }


}
