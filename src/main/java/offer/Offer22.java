package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer22 {

    // 1->2->3->4->5 2   4->5
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        if (head == null) return null;
//        ListNode p = head;
//        List<ListNode> li = new ArrayList<>();
//        while (p != null) {
//            li.add(p);
//            p = p.next;
//        }
//        return li.get(li.size() - k);
//    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode latter = head, former = head;
        for (int i = 0; i < k; ++i) {
            former = former.next;
        }
        while (former != null) {
            latter = latter.next;
            former = former.next;
        }
        return latter;
    }


}