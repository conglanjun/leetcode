package leetcode.problem524;

import java.util.ArrayList;
import java.util.List;

public class LongestWord1 {

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (int i = 0; i < d.size(); ++i) {
            String target = d.get(i);
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            int si = 0;
            int di = 0;
            while (si < s.length() && di < target.length()) {
                if (s.charAt(si) == target.charAt(di)) {
                    ++di;
                }
                ++si;
            }
            if (di == target.length()) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        List<String> d = new ArrayList<String>();
        d.add("apple");
        d.add("ewaf");
        d.add("awefawfwaf");
        d.add("awef");
        d.add("awefe");
        d.add("ewafeffewafewf");
        LongestWord1 l = new LongestWord1();
        String ret = l.findLongestWord("aewfafwafjlwajflwajflwafj", d);
        System.out.println(ret);
    }

}
