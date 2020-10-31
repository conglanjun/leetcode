package leetcode.problem978;

public class Longest {

    // [9,4,2,10,7,8,8,1,9]
    // (A[1] > A[2] < A[3] > A[4] < A[5])
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] dp = new int[A.length];
        int max = 0;
        dp[0] = 1;
        if (A.length == 1) return 1;
        int flag = -1; // 0:letter, 1:greater
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > A[i - 1]) {
                if (flag == 0 || flag == -1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 2;
                }
                flag = 1;
            } else if (A[i] < A[i - 1]) {
                if (flag == 1 || flag == -1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 2;
                }
                flag = 0;
            } else {
                dp[i] = 1;
                flag = -1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Longest l = new Longest();
        int i = l.maxTurbulenceSize(new int[]{100});
        System.out.println(i);
    }

}
