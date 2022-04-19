package top.alin.solution;

import top.alin.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    class Solution {
        public void reorderList(ListNode head) {
            ListNode curr = head.next;
            List<ListNode> list = new ArrayList<>();
            while(curr != null) {
                list.add(curr);
                curr = curr.next;
            }
            curr = head;
            for(int i = 0, j = list.size() - 1; i <= j; i++, j--) {
                curr.next = list.get(j);
                curr = curr.next;
                if (i != j) {
                    curr.next = list.get(i);
                    curr = curr.next;
                }
            }
            curr.next = null;
        }
    }

    class Solution2 {
        public void reorderList(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode l2 = reverseList(mid.next);
            mid.next = null;
            mergeList(head, l2);
        }

        ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next !=  null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }

        void mergeList(ListNode l1, ListNode l2) {
            ListNode l1_tmp;
            ListNode l2_tmp;
            while (l1 != null && l2 != null) {
                l1_tmp = l1.next;
                l2_tmp = l2.next;

                l1.next = l2;
                l1 = l1_tmp;

                l2.next = l1;
                l2 = l2_tmp;
            }
        }
    }
}
