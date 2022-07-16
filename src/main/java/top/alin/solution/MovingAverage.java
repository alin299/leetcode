package top.alin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {
    int size;
    double sum;
    Deque<Integer> q;
    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        q = new ArrayDeque<>();
    }

    public double next(int val) {
        if(q.size() == size) {
            sum -= q.poll();
        }
        q.offer(val);
        sum += val;
        return sum / q.size();
    }
}
