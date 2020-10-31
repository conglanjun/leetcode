package offer;

public class Offer05ReplaceSpace {

    public String replaceSpace(String s) {
        int spaceCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int originIndex = s.length() - 1;
        int newStrIndex = s.length()  + spaceCount * 2 - 1;
        char[] chars = new char[newStrIndex + 1];
        char[] charsOrigin = s.toCharArray();
        for (int i = 0; i < charsOrigin.length; ++i) {
            chars[i] = charsOrigin[i];
        }
        for (int i = originIndex; i >= 0; --i) {
            if (chars[i] == ' ') {
                chars[newStrIndex--] = '0';
                chars[newStrIndex--] = '2';
                chars[newStrIndex--] = '%';
            } else {
                chars[newStrIndex--] = chars[i];
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "  ";
        Offer05ReplaceSpace f = new Offer05ReplaceSpace();
        String s1 = f.replaceSpace(s);
        System.out.println(s1);
    }

}
