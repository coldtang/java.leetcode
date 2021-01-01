package com.tang.january;

import java.util.Stack;

/**
 * 力扣 最小栈
 *
 * @author tang
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer topValue = dataStack.pop();
        if (topValue.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
