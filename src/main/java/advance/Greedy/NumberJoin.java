package advance.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NumberJoin {

    public int[] li = {32, 94, 128, 1286, 6, 71};

    public String[] numberJoin(int[] li) {
        String[] strs = new String[li.length];
        for (int i = 0; i < li.length; ++i) {
            strs[i] = String.valueOf(li[i]);
        }
        Arrays.sort(strs, 0, strs.length, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        return strs;
    }

    public static void main(String[] args) {
        NumberJoin n = new NumberJoin();
        String[] strings = n.numberJoin(n.li);
        for (int i = 0; i < strings.length; ++i) {
            System.out.print(strings[i] + ",");
        }
    }
}
