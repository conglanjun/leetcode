package leetcode.problem7;

public class Reverse {
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int temp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = res*10 + temp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Reverse s = new Reverse();
        System.out.println(s.reverse(123));
    }
}
