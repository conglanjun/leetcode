package leetcode.problem5;

import java.util.ArrayList;
import java.util.List;

public class Longest {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int max = 0;
        String res = "";
        boolean[][] dp = new boolean[len][len];
        for (int l = 0; l < len; ++l) {
            for (int i = 0; i + l < len; ++i) {
                int j = i + l;
                if (l == 0) dp[i][j] = true;
                else if (l == 1) {
                    dp[i][j] = chars[i] == chars[j];
                } else {
                    dp[i][j] = chars[i] == chars[j] && dp[i + 1][j - 1];
                }
                if (dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Longest l = new Longest();
        String s = l.longestPalindrome("abacd");
        System.out.println(s);
        System.out.println(l.longestPalindrome1("abacd"));
    }

    public String longestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int len = s.length();
        boolean [][] dp = new boolean[len][len];
        String ret = "";
        for (int l = 0; l < len; l++) { // l -> string length
            for (int i = 0; i + l < len; i++) { // i string's left index
                int j = i + l; // j string's right index
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = chars[i] == chars[j];
                } else {
                    dp[i][j] = chars[i] == chars[j] && dp[i+1][j-1];
                }
                if (dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    ret = s.substring(i, j + 1);
                }
            }
        }
        return ret;
    }
}
