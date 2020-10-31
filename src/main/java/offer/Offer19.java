package offer;

public class Offer19 {

    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for (int i = 0; i < plen; ++i) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < slen; ++i) {
            for (int j = 0; j < plen; ++j) {
                if (s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    // 1, 2+
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                    }
                    dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i + 1][j - 1];
                } else {
                    dp[i + 1][j + 1] = false;
                }
            }
        }
        return dp[slen][plen];
    }

}
