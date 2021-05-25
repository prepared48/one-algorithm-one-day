package com.prepared.leetCode.LinkedList;

import com.prepared.baseutil.PrintUtil;

/**
 * 24. 两两交换链表中的节点
 *
 * @Author: zhongshibo
 * @Date: 2021/5/25 11:32
 */
public class Day24MulChange24 {

    public static void main(String[] args) {
        Day24MulChange24 mulChange24 = new Day24MulChange24();
        ListNode node1 = new ListNode(6, null);
        ListNode node2 = new ListNode(5, node1);
        ListNode node3 = new ListNode(4, node2);
        ListNode node4 = new ListNode(3, node3);
        ListNode node6 = new ListNode(2, node4);
        ListNode node7 = new ListNode(1, node6);
        PrintUtil.print(node7);
        ListNode newHead = mulChange24.swapPairs(node7);
        PrintUtil.print(newHead);
    }

    /**
     * 递归解法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * 非递归解法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        // 增加虚拟节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;

        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
