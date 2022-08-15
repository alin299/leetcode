package top.alin.solution;

public class DesignCircularQueue {
    class MyCircularQueue {
        int[] q;
        int head, tail, capacity;
        public MyCircularQueue(int k) {
            capacity = k + 1;
            q = new int[capacity];
        }

        public boolean enQueue(int value) {
            if(isFull()) {
                return false;
            }
            q[tail] = value;
            tail = (tail + 1) % capacity;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
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
            return q[(tail + capacity - 1) % capacity];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return (tail + 1) % capacity == head;
        }
    }
}
