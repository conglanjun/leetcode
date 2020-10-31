package leetcode.problem50;

public class MyPow {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double res = 1.0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        MyPow m = new MyPow();
        double v = m.myPow(2, 3);
        System.out.println(v);
    }


}
