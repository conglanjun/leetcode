package leetcode.problem143;

import java.util.ArrayList;
import java.util.List;

public class ReSortedLink {

//    public void reorderList(ListNode head) {
//        if (head == null) return;
//        List<ListNode> li = new ArrayList<>();
//        ListNode p = head;
//        while (p != null) {
//            li.add(p);
//            p = p.next;
//        }
//        int startP = 0;
//        int endP = li.size() - 1;
//        while (startP < endP - 1) {
//            li.get(endP).next = li.get(startP).next;
//            li.get(startP).next = li.get(endP);
//            li.get(endP - 1).next = null;
//            startP++;
//            endP--;
//        }
//    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;//中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead;
        return outTail;
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
        ReSortedLink r = new ReSortedLink();
        r.reorderList(l1);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
1-5-2-4-3
1 2 3 4 5     5
  2 3 4 5     3    tail =4->5          2->4->3     outtail=5                  subhead=3->null
    3 4 5     1                return 4->5        3->null
 */
