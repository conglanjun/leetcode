package leetcode.problem141;

public class LinkedListCycle {

//    public boolean hasCycle(ListNode head) {
//        if (head == null) {
//            return false;
//        }
//        ListNode p1 = head, p2 = head.next;
//        while (p1 != null && p2 != null && p2.next != null) {
//            if (p1 == p2) {
//                return true;
//            }
//            p1 = p1.next;
//            p2 = p2.next.next;
//        }
//        return false;
//    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        LinkedListCycle l = new LinkedListCycle();
        System.out.println(l.hasCycle(head));
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