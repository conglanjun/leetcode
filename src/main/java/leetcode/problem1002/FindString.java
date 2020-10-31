package leetcode.problem1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindString {

    public List<String> commonChars(String[] A) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (int i = 0; i < A.length; ++i) {
            int[] freq = new int[26];
            String str = A[i];
            for (int j = 0; j < str.length(); ++j) {
                char c = str.charAt(j);
                freq[c - 'a']++;
            }
            for (int j = 0; j < 26; ++j) {
                minFreq[j] = Math.min(minFreq[j], freq[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minFreq[i]; ++j) {
                ans.add(String.valueOf((char)(i + 'a')));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindString f = new FindString();
        List<String> strings = f.commonChars(new String[]{"bella", "label", "roller"});
        System.out.println(strings);
    }

}

