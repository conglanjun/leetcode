package leetcode.problem5601;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderedStream {

    String[] strings;
    int ptr = 0;

    public OrderedStream(int n) {
        strings = new String[n+1];
        ptr = 1;
    }

    public List<String> insert(int id, String value) {
        List<String> res = new ArrayList<>();
        strings[id] = value;
        while (ptr < strings.length && strings[ptr] != null) {
            res.add(strings[ptr++]);
        }
        return res;
    }

    public static void main(String[] args) {
        OrderedStream obj = new OrderedStream(5);
        List<String> param_1 = obj.insert(3, "ccccc");
        List<String> param_2 = obj.insert(1, "aaaaa");
        List<String> param_3 = obj.insert(2, "bbbbb");
        List<String> param_4 = obj.insert(5, "eeeee");
        List<String> param_5 = obj.insert(4, "ddddd");
    }

}
