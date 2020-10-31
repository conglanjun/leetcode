package advance.Greedy;

public class Greedy {
    public int[] t = new int[]{100, 50, 20, 5, 1};

    public Result change(int[] t, int n) {
        int[] m = new int[t.length];
        for (int i = 0; i < m.length; ++i) {
            m[i] = 0;
        }
        for (int i = 0; i < t.length; ++i) {
            m[i] = n / t[i];
            n = n % t[i];
        }
        return new Result(m, n);
    }

    public static void main(String[] args) {
        Greedy g = new Greedy();
        Result ret = g.change(g.t, 376);
        System.out.println(ret);
    }
}

class Result {
    public int[] retli;
    public int remain;

    public Result(int[] retli, int remain) {
        this.retli = retli;
        this.remain = remain;
    }

    @Override
    public String toString() {
        StringBuffer ss = new StringBuffer();
        ss.append("[");
        for (int i = 0; i < retli.length; ++i) {
            ss.append(retli[i]);
            if (i == retli.length - 1) {
                ss.append("]");
            } else {
                ss.append(",");
            }
        }
        ss.append(" ");
        ss.append(remain);
        return ss.toString();
    }
}
