package advance.dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibnacci {

    public int fibnacci(int n) {
        if (n ==1 || n == 2) {
            return 1;
        }
        return fibnacci(n - 1) + fibnacci(n - 2);
    }

    public int fibnacciNoRec(int n) {
        Integer[] fibs = {0, 1, 1};
        List<Integer> li = new ArrayList<Integer>(Arrays.asList(fibs));
        if (n > 2) {
            for (int i = 2; i < n; ++i) {
                int sum = li.get(li.size() - 2) + li.get(li.size() - 1);
                li.add(sum);
            }
        }
        return li.get(li.size() - 1);
    }

    public static void main(String[] args) {
        Fibnacci f = new Fibnacci();
        int ret = f.fibnacci(40);
        System.out.println(ret);
        int ret1 = f.fibnacciNoRec(50);
        System.out.println(ret1);
    }
}
