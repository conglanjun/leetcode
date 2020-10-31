package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer101Fibnacci {

    // 0 1 1 2 3 5 8 13 21 34 55
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        Integer[] a = {0, 1, 1};
        List<Integer> li = new ArrayList<>(Arrays.asList(a));
        if (n > 2) {
            for (int i = 2; i < n; ++i) {
                int sum = li.get(li.size() - 1) + li.get(li.size() - 2);
                li.add(sum % 1000000007);
            }
        }
        return li.get(li.size() - 1);
    }

    // 0 1 1 2 3 5
    public int fib(int n) {
        if (n == 0) return 0;
        int a = 0, b = 1, sum;
        for (int i = 0; i < n - 1; ++i) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        Offer101Fibnacci o = new Offer101Fibnacci();
        int fib = o.fib(5);
        System.out.println(fib);
    }

}
