package leetcode.LCP19;

public class Leaves {

    // leaves = "rrryyyrryyyrr"
    public int minimumOperations(String leaves) {
        int[][] dp = new int[3][];
        for (int i = 0; i < 3; ++i) {
            dp[i] = new int[leaves.length()];
        }
        for (int i = 0; i < leaves.length(); ++i) {
            if (i == 0) {
                dp[0][i] = leaves.charAt(i) != 'r' ? 1: 0;
            } else {
                dp[0][i] = dp[0][i - 1] + (leaves.charAt(i) != 'r' ? 1: 0);
            }
            if (i == 0) {
                dp[1][i] = dp[0][i];
            } else {
                dp[1][i] = Math.min(dp[1][i - 1] + (leaves.charAt(i) != 'y' ? 1: 0), dp[0][i - 1] + (leaves.charAt(i) != 'y' ? 1: 0));
            }
            if (i < 2) {
                dp[2][i] = dp[1][i];
            } else {
                dp[2][i] = Math.min(dp[1][i - 1] + (leaves.charAt(i) != 'r' ? 1: 0), dp[2][i - 1] + (leaves.charAt(i) != 'r' ? 1: 0));
            }
        }
        return dp[2][leaves.length() - 1];
    }

    public static void main(String[] args) {
        String leaves = "rrryyyrryyyrr";
        Leaves l = new Leaves();
        int result = l.minimumOperations(leaves);
        System.out.println(result);
    }

}
