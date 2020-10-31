package leetcode.problem925;

public class PressKey {

    // name = "alex", typed = "aaleex"
    public boolean isLongPressedName(String name, String typed) {
        int nl = name.length();
        int tl = typed.length();
        int pn = 0, pt = 0;
        char pre = ' ';
        while (pn < nl && pt < tl) {
            char nc = name.charAt(pn);
            char tc = typed.charAt(pt);
            if (nc == tc) {
                pn++;
                pt++;
                pre = nc;
                continue;
            } else if (pre == tc) {
                pt++;
                continue;
            }
            return false;
        }
        while (pt < tl) {
            char tc = typed.charAt(pt);
            if (pre == tc) {
                pt++;
            } else {
                return false;
            }
        }
        return pn == nl && pt == tl;
    }

    public static void main(String[] args) {
        PressKey p = new PressKey();
        boolean b = p.isLongPressedName("alex", "alexxr");
        System.out.println(b);
    }

}
