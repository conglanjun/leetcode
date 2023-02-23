package leetcode.problem14;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) { // iterate string array
            int ansIndex = 0;
            for(;ansIndex < ans.length() && ansIndex < strs[i].length(); ansIndex++) {
                if (ans.charAt(ansIndex) != strs[i].charAt(ansIndex)) {
                    break;
                }
            }
            ans = strs[i].substring(0, ansIndex);
            if (ans.equals("")) {
                return "";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
