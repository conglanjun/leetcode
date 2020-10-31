package leetcode;

public class demo1 {

    public int getLongest(String str) {
        if (str == null || str.length() == 0) return 0;
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for(int i = 1; i < str.length(); ++i) {
            char c1 = str.charAt(i);
            int j;
            for(j = 0; j < i; ++j) {
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

    public static void main(String[] args) {
        demo1 d = new demo1();
        int abcda = d.getLongest("abcjdkaaa");
        System.out.println(abcda);
    }
}
