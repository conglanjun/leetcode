package leetcode.problem5603;

import java.util.HashMap;
import java.util.Map;

public class Strings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        for (int i = 0; i < word1.length(); ++i) {
            if (!word2.contains(String.valueOf(word1.charAt(i)))) {
                return false;
            }
        }
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < word1.length(); ++i) {
            String s = String.valueOf(word1.charAt(i));
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word2.length(); ++i) {
            String s = String.valueOf(word2.charAt(i));
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        for (String key: map1.keySet()) {
            if (!map2.containsKey(key)) {
                return false;
            }
        }

        for (String key: map1.keySet()) {
            int count = map1.get(key);
            String del = "";
            for (String key2: map2.keySet()) {
                if (map2.get(key2) == count) {
                    del = key2;
                    break;
                }
            }
            if (del.isEmpty()) return false;
            map2.remove(del);
        }

        return true;
    }

    public static void main(String[] args) {
        Strings s = new Strings();
        s.closeStrings("abbzzca", "babzzcz");
    }
//"abbzzca"
//"babzzcz"
}
