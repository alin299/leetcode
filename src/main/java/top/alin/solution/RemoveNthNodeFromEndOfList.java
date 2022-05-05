package top.alin.solution;

import top.alin.common.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode dummyNode = new ListNode(-1, head);
        int len = 0;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        curr = dummyNode;
        n = len - n;
        while(n > 0) {
            curr = curr.next;
            n--;
        }
        curr.next = curr.next.next;
        return dummyNode.next;
    }
}
