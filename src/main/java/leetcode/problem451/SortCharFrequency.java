package leetcode.problem451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharFrequency {

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < chars.length; ++i) {
            charMap.put(chars[i], charMap.getOrDefault(chars[i], 0) + 1);
        }
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char key: charMap.keySet()) {
            int frequency = charMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuffer res = new StringBuffer();
        for (int i = bucket.length - 1; i >0; --i) {
            if (bucket[i] == null) {
                continue;
            }
            for (int c = 0; c < bucket[i].size(); ++c) {
                for (int k = 0; k < i; ++k) {
                    res.append(bucket[i].get(c));
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        SortCharFrequency s = new SortCharFrequency();
        System.out.println(s.frequencySort("tree"));
    }

}
