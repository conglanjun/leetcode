package leetcode.problem5602;

import java.util.ArrayList;
import java.util.List;

public class Oper {

    List<Node> calc = new ArrayList<>();

    public int minOperations(int[] nums, int x) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            list.add(nums[i]);
        }
        int lp = 0;
        int rp = list.size() - 1;
        while (x > 0 && lp <= rp) {
            int left = list.get(lp);
            int right = list.get(rp);
            if (left >= right && left <= x) {
                x -= left;
                calc.add(new Node(left, x));
                lp++;
            }else if ((left > x || right >= left) && right <= x) {
                x -= right;
                calc.add(new Node(right, x));
                rp--;
            } else {
                return -1;
            }
        }
        if (lp > rp && x > 0) return -1;
        return calc.size();
    }

    public static void main(String[] args) {
        Oper o = new Oper();
        int[] nums = {1,1};
        o.minOperations(nums, 3);
    }

}

class Node {
    int index;
    int value;
    public Node(int i, int x) {
        index = i;
        value = x;
    }
}