package com.prepared.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 *
 */
public class Day42StackQueue232 {

    Deque<Integer> inStack;
    Deque<Integer> outStack;



    public Day42StackQueue232() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
