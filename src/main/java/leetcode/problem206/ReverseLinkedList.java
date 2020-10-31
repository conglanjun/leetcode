package leetcode.problem206;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        List<ListNode> li = new ArrayList<>();
        while (head != null) {
            li.add(head);
            head = head.next;
        }
        ListNode reverseHead = new ListNode(li.get(li.size() - 1).val);
        ListNode res = reverseHead;
        for (int i = li.size() - 2; i >= 0; --i) {
            reverseHead.next = new ListNode(li.get(i).val);
            reverseHead = reverseHead.next;
        }
        return res;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
