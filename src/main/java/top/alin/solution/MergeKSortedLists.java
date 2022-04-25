package top.alin.solution;

import top.alin.common.ListNode;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists) {
            if (list != null) {
                q.offer(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(!q.isEmpty()) {
            ListNode node = q.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                q.offer(node.next);
            }
        }
        return head.next;
    }
}
