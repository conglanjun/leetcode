package leetcode.problem2;

public class AddTwoNumber1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ten = 0;
        ListNode res = new ListNode(0);
        ListNode result = res;
        while (l1 != null || l2 != null) {
            int sum = ten;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null){
                sum += l2.val;
            }
            ten = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (ten == 1) {
            res.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumber1 s = new AddTwoNumber1();
        ListNode ret = s.addTwoNumbers(l1, l2);
        System.out.println(ret);
    }

}
