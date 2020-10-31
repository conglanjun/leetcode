package offer;

public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode back = pre;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                return back.next;
            }
            pre = pre.next;
        }
        return back.next;
    }

}
