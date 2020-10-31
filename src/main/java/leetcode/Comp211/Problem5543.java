package leetcode.Comp211;

public class Problem5543 {

    public int maxLengthBetweenEqualCharacters(String s) {
        if (s.length() == 0 || s.length() == 1) return -1;
        int max = -1;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = s.length() - 1; j > i; --j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i - 1 > max) {
                        max = j - i -1;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem5543 p = new Problem5543();
        int abca = p.maxLengthBetweenEqualCharacters("aa");
        System.out.println(abca);
    }

}
