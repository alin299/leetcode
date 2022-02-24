package top.alin.solution;

import top.alin.common.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode curr = head;
        while(curr.next != null) {
            ++len;
            curr = curr.next;
        }

        k = k % len;
        if(k == 0) {return head;}

        curr.next = head;
        k = len - k - 1;

        curr = head;
        while(k-- > 0) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;

        return newHead;
    }
}
