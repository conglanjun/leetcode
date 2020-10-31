package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer14Cut {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i / 2 + 1; ++j) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Offer14Cut o = new Offer14Cut();
        int i = o.cuttingRope(3);
        System.out.println(i);
    }

}
