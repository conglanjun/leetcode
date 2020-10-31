package leetcode.problem844;

public class Compare {

    // S = "ab#c", T = "ad#c"
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Compare c = new Compare();
        boolean b = c.backspaceCompare("ab#c", "ad#c");
        System.out.println(b);
    }

}
