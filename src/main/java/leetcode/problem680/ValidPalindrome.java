package leetcode.problem680;

public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return isPalindrome(s, i - 1, j) || isPalindrome(s, i, j + 1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        if (s.length() == 0) {
            return false;
        }
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.validPalindrome("abc"));
    }

}
