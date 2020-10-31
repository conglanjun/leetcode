package examin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Content {

    public List<String> recover(int n, String[] s) {
        List<String> li = new ArrayList<>();
        permutation(s, li, 0);
        return li;
    }

    public void permutation(String[] s, List<String> res,int cur) {
        int len = s.length;
        if (cur == len - 1) {
            res.add(s[cur]);
            return;
        }
        for (int i = 0; i < s.length; ++i) {
            swap(s[i], s[cur]);
            permutation(s, res, cur + 1);
            swap(s[i], s[cur]);
        }
    }

    private void swap(String s, String t) {
        String tmp = s;
        s = t;
        t = tmp;
    }

    public static void main(String[] args) {
        Content c = new Content();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = {"a", "b", "c"};
        List<String> recover = c.recover(n, strings);
        System.out.println(recover);
    }

}
