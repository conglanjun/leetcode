package offer;

public class Offer102Stage {

    // 5    1,4 2,3 3,2 4,1
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1, b = 1, sum;
        for (int i = 0; i < n - 1; ++i) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }

}
