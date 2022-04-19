package top.alin.solution;

import top.alin.common.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = null;
        ListNode end = null;
        ListNode vNode = new ListNode(0, head);
        ListNode curr = vNode;
        int i = 0;
        while(curr != null) {
            if (i == left) {
                start = curr;
            }
            if (i == right) {
                end = curr;
            }
            if (i == left - 1) {
                head = curr;
            }
            curr = curr.next;
            i++;
        }

        curr = start;
        ListNode pre = end.next;
        end.next = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head.next = pre;
        return vNode.next;
    }
}
