package leetcode.p2AddTwoNumbers;

public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution s = new Solution();
        ListNode ret = s.addTwoNumbers(l1, l2);
        System.out.println(ret);
    }
}

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode ret = new ListNode();
        ListNode result = ret;
        int ten = 0;
        while (l1 != null || l2 != null) {
            int sum = ten;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            ten = sum / 10;
            ret.next = new ListNode(sum % 10);
            ret = ret.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (ten == 1) {
            ret.next = new ListNode(1);
        }
        return result.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int ten = 0;
        ListNode result = new ListNode();
        ListNode ret = result;
        while (l1 != null || l2!= null) {
            int sum = ten;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            ten = sum / 10;
            result.next = new ListNode(sum % 10) ;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            result = result.next;
        }
        if (ten == 1) {
            result.next = new ListNode(1);
        }
        return ret.next;
    }
}
