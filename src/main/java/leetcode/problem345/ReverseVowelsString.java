package leetcode.problem345;

public class ReverseVowelsString {

    public String reverseVowels(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        boolean findLeft = false;
        boolean findRight = false;
        while (i < j) {
            if(!containChar(chars[i], vowels)) {
                ++i;
            } else {
                findLeft = true;
            }
            if(!containChar(chars[j], vowels)) {
                --j;
            } else {
                findRight = true;
            }
            if (findLeft && findRight) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                findLeft = false;
                findRight = false;
                ++i;
                --j;
            }
        }
        return new String(chars);
    }

    public boolean containChar(char c, char[] vow) {
        for (int i = 0; i < vow.length; ++i) {
            if(vow[i] == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReverseVowelsString r = new ReverseVowelsString();
        System.out.println(r.reverseVowels("hello"));
    }

}
