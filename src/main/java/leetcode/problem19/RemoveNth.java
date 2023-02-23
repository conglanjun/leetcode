package leetcode.problem19;

import java.util.ArrayList;
import java.util.List;

public class RemoveNth {

    // 1->2->3->4->5, n = 2.  1->2->3->5.
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null) return null;
//        ListNode pre = new ListNode(0);
//        pre.next = head;
//        ListNode p = head;
//        List<ListNode> li = new ArrayList<>();
//        while (p != null) {
//            li.add(p);
//            p = p.next;
//        }
//        int len = li.size();
//        int index = len - n;
//        if (index == 0) {
//            pre.next = pre.next.next;
//        } else {
//            li.get(index - 1).next = li.get(index).next;
//        }
//        return pre.next;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        ListNode q = pre;
        for (int i = 0; i < n + 1; ++i) {
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        RemoveNth r = new RemoveNth();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        ListNode listNode = r.removeNthFromEnd(l1, 2);
//        System.out.println(listNode);
        System.out.println(r.removeNthFromEnd1(l1, 2));
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        ListNode q = pre;
        for (int i = 0; i < n + 1;i ++) {
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return pre.next;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}