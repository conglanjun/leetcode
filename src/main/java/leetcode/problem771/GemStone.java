package leetcode.problem771;

public class GemStone {

    // J = "aA", S = "aAAbbbb"
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] JChars = J.toCharArray();
        char[] SChars = S.toCharArray();
        for (int i = 0; i < SChars.length; ++i) {
            for (int j = 0; j < JChars.length; ++j) {
                if (JChars[j] == SChars[i]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String S = "aAAbbbb";
        String J = "aA";
        GemStone g = new GemStone();
        int count = g.numJewelsInStones(J, S);
        System.out.println(count);
    }

}
