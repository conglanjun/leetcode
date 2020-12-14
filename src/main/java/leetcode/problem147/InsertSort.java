package leetcode.problem147;

public class InsertSort {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dumpHead = new ListNode(0);
        dumpHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dumpHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        InsertSort i = new InsertSort();
        i.insertionSortList(l1);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}