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
        System.out.println(n.lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(n.lengthOfLongestSubstring2("abcabcbb"));
    }

    public int lengthOfLongestSubstring1(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int result = 0;
        for (end = 0; end < s.length(); end++) {
            int temp = s.charAt(end);
            for (int index = start; index < end; index++) {
                if (temp == s.charAt(index)) {
                    start = index + 1;
                    maxLength = end - start;
                    break;
                }
            }
            maxLength++;
            result = Math.max(result, maxLength);
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int start = 0;
        int max = 0;
        int res = 0;
        for (int end = 0; end < len; end++) {
            for (int left = start; left < end; left++) {
                if (chars[left] == chars[end]) {
                    start = left + 1;
                    max = end - start;
                    break;
                }
            }
            max++;
            res = Math.max(max, res);
        }
        return res;
    }

}
