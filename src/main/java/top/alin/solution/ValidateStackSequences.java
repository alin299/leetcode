package top.alin.solution;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            };
        }
        return stack.isEmpty();
    }
}
