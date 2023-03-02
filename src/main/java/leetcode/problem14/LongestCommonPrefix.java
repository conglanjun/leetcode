package leetcode.problem14;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) { // iterate string array
            int ansIndex = 0;
            for (; ansIndex < ans.length() && ansIndex < strs[i].length(); ansIndex++) {
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
        System.out.println(l.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(l.longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String ans = strs[0];
        int ansIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            for (ansIndex = 0; ansIndex < ans.length() && ansIndex < strs[i].length(); ansIndex++) {
                if (ans.charAt(ansIndex) != strs[i].charAt(ansIndex)) {
                    break;
                }
            }
            ans = ans.substring(0, ansIndex);
            if ("".equals(ans)) {
                return "";
            }
        }
        return ans;
    }
}


// chart gpt
class LongestCommonPrefixGPT {

    public static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String longestCommonPrefix = findLongestCommonPrefix(strs);
        System.out.println("Longest common prefix is: " + longestCommonPrefix);
    }
}