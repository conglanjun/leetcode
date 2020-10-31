package leetcode.problem474;

import java.util.Arrays;
import java.util.Comparator;

public class OneAndZero {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; ++i) {
            String s = strs[i];
            int countZ = 0;
            int countO = 0;
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == '0') countZ++;
                else if (s.charAt(j) == '1') countO++;
            }
            for (int zeros = m; zeros >= countZ; --zeros) {
                for (int ones = n; ones >= countO; --ones) {
                    dp[zeros][ones] = Math.max(1 + dp[zeros - countZ][ones - countO], dp[zeros][ones]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        OneAndZero o = new OneAndZero();
        String[] str = {"10", "0001", "111001", "1", "0"};
        int maxForm = o.findMaxForm(str, 5, 3);
        System.out.println(maxForm);
    }

}
