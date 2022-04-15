package top.alin.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MiniParser {
    /**
    * public NestedInteger deserialize(String s) {
    *     char[] chars = s.toCharArray();
    *     int n = s.length();
    *     Stack<NestedInteger> stack = new Stack<>();
    *     NestedInteger flag =  new NestedInteger(100001);
    *     int i = 0;
    *     while(i < n) {
    *         if (chars[i] == ',') {
    *             i++;
    *         } else if (chars[i] == '[') {
    *             stack.push(new NestedInteger());
    *             stack.push(flag);
    *             i++;
    *         } else if (chars[i] == ']') {
    *             List<NestedInteger> list = new ArrayList<>();
    *             while(!stack.isEmpty()) {
    *                 NestedInteger peek = stack.pop();
    *                 if (peek == flag) break;
    *                 list.add(peek);
    *             }
    *             for(int j = list.size() - 1; j >= 0; j--) {
    *                 stack.peek().add(list.get(j));
    *             }
    *             i++;
    *         } else {
    *             int j = i + 1;
    *             while(j < n && (chars[j] == '-' || Character.isDigit(chars[j]))) {
    *                 j++;
    *             }
    *             stack.push(new NestedInteger(Integer.valueOf(s.substring(i, j))));
    *             i = j;
    *         }
    *     }
    *     return stack.peek();
    * }
    * /

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
}
