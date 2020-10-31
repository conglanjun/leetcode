package leetcode.problem524;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestWord {

    public String findLongestWord(String s, List<String> d) {
        String[] li = new String[d.size()];
        Arrays.sort(d.toArray(li), 0, d.size(), new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    if (o1.compareTo(o2) < 1) {
                        return -1;
                    }
                }
                return 1;
            }
        });
        for (int k = 0; k < li.length; ++k) {
            int j = 0; // the index of d'chars
            for (int i = 0; i < s.length(); ++i) {
                char sChar = s.charAt(i);
                if (sChar == li[k].charAt(j)) {
                    if (++j == li[k].length()) {
                        return li[k];
                    }
                }
                continue;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        List<String> d = new ArrayList<String>();
        d.add("apple");
        d.add("ewaf");
        d.add("awefawfwaf");
        d.add("awef");
        d.add("awefe");
        d.add("ewafeffewafewf");
        LongestWord l = new LongestWord();
        String ret = l.findLongestWord("aewfafwafjlwajflwajflwafj", d);
        System.out.println(ret);
    }

}
