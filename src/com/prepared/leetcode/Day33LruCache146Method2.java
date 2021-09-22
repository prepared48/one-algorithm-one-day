package com.prepared.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


/**
 * 散列表+双向链表 实现LRU
 *
 */
public class Day33LruCache146Method2 {

    public static void main(String[] args) {
        Day33LruCache146Method2 cache = new Day33LruCache146Method2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);

        cache.put(3, 3);
        System.out.println(cache.get(2));

        cache.put(4, 4);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    // 双线链表

    class DLinkedNode {

        int key;

        int value;

        DLinkedNode prev;

        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    private int size;

    private int capacity;

    private DLinkedNode head, tail;

    public Day33LruCache146Method2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用虚拟头节点和尾节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 移动到头部，返回value
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = new DLinkedNode(key, value);

        if(cache.get(key) == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addHead(newNode);
            ++size;

            // 如果超出了容量限制，删除尾节点
            if(size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }


    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}