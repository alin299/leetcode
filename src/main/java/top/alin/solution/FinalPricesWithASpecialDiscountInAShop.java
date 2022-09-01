package top.alin.solution;

import java.util.Deque;
import java.util.LinkedList;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                prices[stack.peek()] -= prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        return prices;
    }
}
