package leetcode.p1590MakeSumDivisibkeByP;

public class MakeSumDivisible {
    public int minSubarray(int[] nums, int p) {
        if (nums == null || nums.length == 0 || p == 0) {
            return 0;
        }
        int len = nums.length;
        int result = len;
        boolean[][] dp = new boolean[len][len];
        for (int l = 0; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                if (l == 0) {
                    if (nums[i] % p == 0) {
                        dp[i][l] = true;
                    }
                } else {
                    if (i == 0) continue;
                    if (dp[i - 1][l - 1] && nums[i] % p == 0) {
                        dp[i][l] = true;
                    }
                }
                if (dp[i][l]) {
                    int count = i + len - 1 - l;
                    if (count < result) {
                        result = count;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MakeSumDivisible m = new MakeSumDivisible();
        System.out.println(m.minSubarray(new int[]{3, 1, 4, 2}, 6));
    }
}
