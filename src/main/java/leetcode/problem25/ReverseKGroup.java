package leetcode.problem25;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {

//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode pre = new ListNode(0);
//        pre.next = head;
//        ListNode preBack = pre;
//        ListNode p = head;
//        while (p != null) {
//            int count = k;
//            List<ListNode> back = new ArrayList<>();
//            while (count-- > 0 && p != null) {
//                back.add(p);
//                p = p.next;
//            }
//            if (k > back.size()) {
//                for (int i = 0; i < back.size(); ++i) {
//                    pre.next = back.get(i);
//                    break;
//                }
//                break;
//            }
//            ListNode node = back.get(back.size() - 1);
//            pre.next = node;
//            for (int i = back.size() - 2; i > -1; --i) {
//                node.next = back.get(i);
//                node = node.next;
//            }
//            node.next = null;
//            pre = node;
//        }
//        return preBack.next;
//    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (end != null) {
            for (int i = 0; i < k && end != null; ++i) {
                end = end.next;
            }
            if (end != null) {
                start = swap(start, end.next);
                end = start;
            }
        }
        return pre.next;
    }

    private ListNode swap(ListNode before, ListNode after) {
        ListNode cur = before.next;
        ListNode back = before.next;
        ListNode next = null;
        ListNode later = after;
        while (cur != after) {
            next = cur.next;
            cur.next = later;
            later = cur;
            cur = next;
        }
        before.next = later;
        return back;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ReverseKGroup rg = new ReverseKGroup();
        ListNode listNode = rg.reverseKGroup(l1, 2);
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println();
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
