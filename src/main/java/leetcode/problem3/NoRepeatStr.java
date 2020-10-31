package leetcode.problem3;

public class NoRepeatStr {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            int j;
            for (j = i - dp[i - 1]; j < i; ++j) {
                char c1 = s.charAt(j);
                if (c == c1) {
                    dp[j] = 0;
                    for (int k = j + 1; k < i; ++k) {
                        dp[k] = dp[k - 1] + 1;
                    }
                    break;
                }
            }
            dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        NoRepeatStr n = new NoRepeatStr();
        int abca = n.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abca);
    }

}
