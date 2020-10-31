package advance.dynamicProgram;

import java.util.Date;

public class CutRod {

//    public int[] values = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    public int[] values = {0, 1, 5, 8, 9, 10, 17, 17, 20, 21, 23, 24, 26, 27, 27, 28, 30, 33, 36, 39, 40};

    public int cutRodRec(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int res = p[n];
        for (int i = 1; i < n; ++i) {
            res = Math.max(res, cutRodRec(p, i) + cutRodRec(p, n - i));
        }
        return res;
    }

    public int cutRodRec2(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < n + 1; ++i) {
            res = Math.max(res, p[i] + cutRodRec2(p, n - i));
        }
        return res;
    }

    public int cutRodDp(int[] p, int n) {
        if (p.length == 0) {
            return 0;
        }
        int[] res = new int[p.length];
        res[0] = 0;
        for (int i = 1; i < n + 1; ++i) {
            int result = 0;
            for (int j = 1; j < i + 1; ++j) {
                result = Math.max(result, p[j] + res[i - j]);
            }
            res[i] = result;
        }
        return res[n];
    }

    public int[] cutRodExtend(int[] p, int n) {
        int[] r = new int[p.length];
        int[] s = new int[p.length + 1];
        for (int i = 1; i < n + 1; ++i) {
            int res = 0;
            int res_s = 0;
            for (int j = 1; j < i + 1; ++j) {
                if (res < p[j] + r[i - j]) {
                    res = p[j] + r[i - j];
                    res_s = j;
                }
            }
            r[i] = res;
            s[i] = res_s;
        }
        s[s.length - 1] = r[n];
        return s;
    }

    public int[] cutRodSolution(int[] p, int n) {
        int[] ret = cutRodExtend(p, n);
        int[] ans = new int[n];
        int index = 0;
        while (n > 0) {
            ans[index++] = ret[n];
            n -= ret[n];
        }
        return ans;
    }

    public static void main(String[] args) {
        CutRod c = new CutRod();

//        long start = System.currentTimeMillis();
//        System.out.println(c.cutRodRec(c.values, 20));
//        System.out.println(System.currentTimeMillis() - start);
//
//        start = System.currentTimeMillis();
//        System.out.println(c.cutRodRec2(c.values, 20));
//        System.out.println(System.currentTimeMillis() - start);
//
//        start = System.currentTimeMillis();
//        System.out.println(c.cutRodDp(c.values, 20));
//        System.out.println(System.currentTimeMillis() - start);

//        int[] ret = c.cutRodExtend(c.values, 10);
//        for (int i = 0; i < ret.length; ++i) {
//            System.out.print(ret[i] + ", ");
//        }

        System.out.println(c.cutRodDp(c.values, 20));
        int[] ret = c.cutRodSolution(c.values, 20);
        for (int i = 0; i < ret.length; ++i) {
            System.out.print(ret[i] + ", ");
        }
    }
}
