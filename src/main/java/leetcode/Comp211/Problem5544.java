package leetcode.Comp211;

public class Problem5544 {

    public String findLexSmallestString(String s, int a, int b) {
        String minStr = s;
        int same = 0;
        while (true) {
            String loop = loop(s, b);
            if (minStr.compareTo(loop) > 0) {
                minStr = loop;
            }
            loop = add(loop, a);
            if (minStr.compareTo(loop) > 0) {
                minStr = loop;
            }
            loop = loop(s, b);
            if (minStr.compareTo(loop) > 0) {
                minStr = loop;
            }
            String add = add(s, a);
            if (minStr.compareTo(add) > 0) {
                minStr = add;
            }
            add = add(add, a);
            if (minStr.compareTo(add) > 0) {
                minStr = add;
            }
            add = loop(s, b);
            if (minStr.compareTo(add) > 0) {
                minStr = add;
            }
            if (s.compareTo(minStr) == 0){
                same++;
            }
            if (same == 100) break;
            s = minStr;
        }
        return s;
    }

    private String loop(String s, int  b) {
        String s1 = s.substring(s.length() - b) + s.substring(0, s.length() - b);
        return s1;
    }

    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i+=2) {
            String i1 = String.valueOf((Integer.parseInt(String.valueOf(chars[i])) + a) % 10);
            chars[i] = i1.charAt(0);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Problem5544 p = new Problem5544();
        String l = p.findLexSmallestString("43987654", 7, 3);
        System.out.println(l);
    }

}
