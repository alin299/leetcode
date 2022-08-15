package top.alin.solution;

public class DesignCircularDeque {
    class MyCircularDeque {
        int capacity;
        int head, tail;
        int[] q;

        public MyCircularDeque(int k) {
            capacity = k + 1;
            q = new int[capacity];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = (head + capacity - 1) % capacity;
            q[head] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            q[tail] = value;
            tail = (tail + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) {
                return false;
            }
            tail = (tail + capacity - 1) % capacity;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : q[head];
        }

        public int getRear() {
            return isEmpty() ? -1 : q[(tail + capacity - 1) % capacity];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return(tail + 1) % capacity == head;
        }
    }
}
