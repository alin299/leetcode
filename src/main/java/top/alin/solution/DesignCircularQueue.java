package top.alin.solution;

public class DesignCircularQueue {
    class MyCircularQueue {
        int[] q;
        int head, tail, capcity;
        public MyCircularQueue(int k) {
            capcity = k + 1;
            q = new int[capcity];
        }

        public boolean enQueue(int value) {
            if(isFull()) {
                return false;
            }
            q[tail] = value;
            tail = (tail + 1) % capcity;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capcity;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return q[head];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return q[(tail + capcity - 1) % capcity];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return (tail + 1) % capcity == head;
        }
    }
}
