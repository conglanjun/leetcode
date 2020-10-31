package leetcode.problem416;

public class Partition {

//    public boolean canPartition(int[] nums) {
//        int len = nums.length;
//        if (len == 0) {
//            return false;
//        }
//        int sum = 0;
//        for (int i = 0; i < len; ++i) {
//            sum += nums[i];
//        }
//        if (sum % 2 == 1) {
//            return false;
//        }
//        int m = sum / 2;
//        boolean[][] dp = new boolean[len + 1][m + 1];
//        for (int i = 0; i <= len; ++i) {
//            dp[i][0] = true;
//        }
//        for (int i = 1; i <= len; ++i) {
//            for (int j = 1; j <= m; ++j) {
//                if (j - nums[i - 1] < 0) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
//                }
//            }
//        }
//        return dp[len][m];
//    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < len; ++i) {
            for (int j = sum; j > 0; --j) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        boolean b = p.canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }

}
