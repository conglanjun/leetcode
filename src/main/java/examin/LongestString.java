package examin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestString {

    public String a = "aeiouAEIOU";

    public List<String> longestString(String s){
        int i = 0;
        List<String> li = new ArrayList<>();
        StringBuffer res = new StringBuffer();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (a.contains(String.valueOf(c))) { // find
                res.append(c);
            } else if (res.length() > 0){
                li.add(res.toString());
                res.setLength(0);
            }
            ++i;
        }
        if (res.length() > 0) {
            li.add(res.toString());
        }
        return li;
    }

    public static void main(String[] args) {
        LongestString l = new LongestString();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> li = l.longestString(input);
        int max = 0;
        for (String str: li) {
            if (str.length() > max) {
                max = str.length();
            }
        }
        System.out.println(max);
    }

}
