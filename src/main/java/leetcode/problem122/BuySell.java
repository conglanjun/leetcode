package leetcode.problem122;

public class BuySell {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int cur = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; ++i) {
            int val = prices[i];
            if (cur < val) {
                sum += val - cur;
            }
            cur = val;
        }
        return sum;
    }

}
