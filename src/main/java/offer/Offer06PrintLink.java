package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer06PrintLink {

    public int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> li = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            li.add(p.val);
            p = p.next;
        }
        int[] res = new int[li.size()];
        for (int i = li.size() - 1, j = 0; i >= 0 && j < li.size(); --i, ++j) {
            res[j] = li.get(i);
        }
        return res;
    }

    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        recur(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        list.add(head.val);
    }

}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }
}
