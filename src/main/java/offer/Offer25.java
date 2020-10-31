package offer;

public class Offer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pre = new ListNode(0);
        ListNode back = pre;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pre.next = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }
        while (p1 != null) {
            pre.next = p1;
            pre = pre.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            pre.next = p2;
            pre = pre.next;
            p2 = p2.next;
        }
        return back.next;
    }

}
