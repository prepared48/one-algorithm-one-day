package com.prepared.leetcode.LinkedList.common;

import com.prepared.leetcode.LinkedList.ListNode;

/**
 * 判断链表是否有环
 *
 * @Author: zhongshibo
 * @Date: 2021/5/27 15:56
 */
public class LinkedListIsCircle {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(5);
        ListNode node1 = new ListNode(6, node2);
        node2.next = node1;
        ListNode node3 = new ListNode(4, node2);
        ListNode node4 = new ListNode(3, node3);
        ListNode node6 = new ListNode(2, node4);
        ListNode node7 = new ListNode(1, node6);
//        PrintUtil.print(node7);
        LinkedListIsCircle removeLastN19 = new LinkedListIsCircle();
        boolean flag = removeLastN19.hasCircle(node7);
        System.out.println(flag);
    }

    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCircle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

}
