package top.alin.solution;

public class InsertIntoASortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node cur = head;
        int max = cur.val, min = cur.val;
        while(cur.next != head) {
            cur = cur.next;
            max = Math.max(max, cur.val);
            min = Math.min(min, cur.val);
        }
        if (max == min) {
            node.next = head.next;
            head.next = node;
            return head;
        } else {
            while(!(cur.val == max && cur.next.val == min)) {
                cur = cur.next;
            }
            while(!(insertVal <= min || insertVal >= max) && !(cur.val <= insertVal && insertVal <= cur.next.val)) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
