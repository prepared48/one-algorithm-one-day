package com.prepared.leetcode;

import java.util.*;

public class Day33LruCache146 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public Day33LruCache146(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}
