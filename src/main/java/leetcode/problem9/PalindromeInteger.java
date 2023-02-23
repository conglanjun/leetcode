package leetcode.problem9;

public class PalindromeInteger {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reverse = 0;
        int backX = x;
        while (x != 0) {
            reverse = x % 10 + reverse * 10;
            x /= 10;
        }
        if (backX == reverse) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PalindromeInteger p = new PalindromeInteger();
        System.out.println(p.isPalindrome(121));
    }
}
