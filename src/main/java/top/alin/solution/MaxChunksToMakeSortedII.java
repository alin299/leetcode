package top.alin.solution;

import java.util.Deque;
import java.util.LinkedList;

public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        for(int num : arr) {
            if (!stack.isEmpty() && num < stack.peek()) {
                Integer peek = stack.pop();
                while(!stack.isEmpty() && num < stack.peek()) {
                    stack.pop();
                }
                stack.push(peek);
            } else {
                stack.push(num);
            }
        }
        return stack.size();
    }
}
