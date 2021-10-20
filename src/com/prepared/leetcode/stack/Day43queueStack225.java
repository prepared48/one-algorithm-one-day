package com.prepared.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 225. 用队列实现栈
 *
 * 比较简单，用一个队列就可以实现
 *
 */
public class Day43queueStack225 {

    List<Integer> inQueue;

    public Day43queueStack225() {
        inQueue = new ArrayList<>();
    }

    public void push(int x) {
        inQueue.add(x);
    }

    public int pop() {
        int temp = inQueue.get(inQueue.size() - 1);
        inQueue.remove(inQueue.size() - 1);
        return temp;
    }

    public int top() {
        return inQueue.get(inQueue.size() - 1);
    }

    public boolean empty() {
        return inQueue.isEmpty();
    }
}
