package top.alin.solution;

import top.alin.common.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode vNode = new ListNode(-1, head);
        ListNode tail;
        ListNode pre = vNode;
        while(head != null) {
            tail = pre;
            for(int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return vNode.next;
                }
            }
            ListNode[] res = reverse(head, tail);
            pre.next = res[0];
            tail = res[1];
            pre = tail;
            head = tail.next;
        }
        return vNode.next;
    }

    ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode curr = head;
        while(pre != tail) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return new ListNode[]{pre, head};
    }
}
