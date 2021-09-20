package com.prepared.leetcode.LinkedList;

/**
 * 707. 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * @Author: zhongshibo
 * @Date: 2021/5/24 19:13
 */
public class Day23MyLinkedList707 {

    public static void main(String[] args) {
        Day23MyLinkedList707 linkedList707 = new Day23MyLinkedList707();
        linkedList707.addAtHead(1);
        linkedList707.addAtIndex(1, 2);
        linkedList707.addAtTail(5);

        System.out.println(linkedList707.get(1));
    }

    int size;

    Node head;


    /** Initialize your data structure here. */
    public Day23MyLinkedList707() {
        size = 0;
        head = new Node(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0) {
            return -1;
        }
        int i = 0;
        Node node = null;
        while (index < size && i < size) {
            if(i != index) {
                i++;
                node = head.next;
            }
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // 异常index
        if(index > size) {
            return ;
        }
        if(index < 0) {
            index = 0;
        }
        size++;
        Node node = new Node(val);
        Node prev = head;

        for(int i = 0; i < index; i++) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // 异常index
        if(index > size) {
            return ;
        }
        if(index < 0) {
            return;
        }
        Node prev = head;
        Node cur = head;

        for(int i = 0; i < index; i++) {
            cur = prev;
            prev = prev.next;
        }
        cur.next = prev.next;
    }

    private static class Node<E> {
        int val;
        Node<E> next;

        Node(int x) {
            val = x;
        }
    }
}
