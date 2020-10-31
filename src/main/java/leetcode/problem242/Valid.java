package leetcode.problem242;

public class Valid {

    public boolean isAnagram(String s, String t) {
        int[] dict1 = new int[26];
        int[] dict2 = new int[26];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0; i < ss.length; ++i) {
            dict1[ss[i] - 'a'] += 1;
        }
        for (int i = 0; i < ts.length; ++i) {
            dict2[ts[i] - 'a'] += 1;
        }
        for (int i = 0; i < dict1.length; ++i) {
            if (dict1[i] != dict2[i]) {
                return false;
            }
        }
        return true;
    }

}
