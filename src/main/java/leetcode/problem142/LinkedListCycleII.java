package leetcode.problem142;

public class LinkedListCycleII {

//    public ListNode detectCycle(ListNode head) {
//        if (head == null || head.next == null) return null;
//        ListNode p1 = head, p2 = head;
//        while (p1 != null && p2 != null & p2.next != null) {
//            if (p1 == p2) {
//                break;
//            }
//            p1 = p1.next;
//            p2 = p2.next.next;
//        }
//        p2 = head;
//        while (p1 != p2) {
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return p2;
//    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}