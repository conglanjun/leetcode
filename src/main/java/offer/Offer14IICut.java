package offer;

public class Offer14IICut {

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        if (n ==4) return 4;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    public static void main(String[] args) {
        Offer14IICut o = new Offer14IICut();
        int i = o.cuttingRope(120);
        System.out.println(i);
    }

}
