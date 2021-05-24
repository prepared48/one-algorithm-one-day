package com.prepared.leetCode.LinkedList;

/**
 * 单向链表
 *
 * @Author: zhongshibo
 * @Date: 2021/5/24 16:48
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
