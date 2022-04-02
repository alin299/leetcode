package top.alin.solution;

import top.alin.common.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode curr = ans;
        int d = 0;
        while (l1 != null || l2 != null || d != 0) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int val = a + b + d;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            d = val / 10;
        }
        return ans.next;
    }
}
