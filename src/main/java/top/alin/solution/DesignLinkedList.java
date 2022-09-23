package top.alin.solution;

public class DesignLinkedList {
    Node head;
    int len;

    public DesignLinkedList() {
        head = new Node(-1);
    }

    public int get(int index) {
        if(index >= len) return -1;
        Node cur = head;
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > len) return;
        Node cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = new Node(val, cur.next);
        len++;
    }

    public void deleteAtIndex(int index) {
        if (index >= len) return;
        Node cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        len--;
    }

    class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}


