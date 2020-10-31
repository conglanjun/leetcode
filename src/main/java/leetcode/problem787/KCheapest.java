package leetcode.problem787;

public class KCheapest {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights.length == 0) return 0;
        int[][] dp = new int[n][K+1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= K; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < flights.length; ++i) {
            if (flights[i][0] == src) {
                dp[flights[i][1]][0] = flights[i][2];
            }
        }

        for (int i = 0; i <= K; ++i) {
            dp[src][i] = 0;
        }

        for (int i = 0; i < flights.length; ++i) {
            for (int j = 1; j <= K; ++j) {
               if (dp[flights[i][0]][j -1] != Integer.MAX_VALUE) {
                   dp[flights[i][1]][j] = Math.min(dp[flights[i][1]][j], dp[flights[i][0]][j - 1] + flights[i][2]);
               }
            }
        }
        return dp[dst][K] != Integer.MAX_VALUE ? dp[dst][K] : -1;
    }

    public static void main(String[] args) {
        KCheapest k = new KCheapest();
        int[] l1 = {1, 0, 5};
        int[][] param = new int[1][3];
        param[0] = l1;
        k.findCheapestPrice(2, param, 0, 1, 1);
    }
}
