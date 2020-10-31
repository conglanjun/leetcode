package offer;

public class Offer16 {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer16 o = new Offer16();
        double v = o.myPow(2, -2);
        System.out.println(v);
    }

}
