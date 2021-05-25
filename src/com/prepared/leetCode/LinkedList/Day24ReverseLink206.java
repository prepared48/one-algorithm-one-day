package com.prepared.leetCode.LinkedList;

import com.prepared.baseutil.PrintUtil;

/**
 * 206. 反转链表
 *
 * @Author: zhongshibo
 * @Date: 2021/5/25 11:12
 */
public class Day24ReverseLink206 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(6, null);
        ListNode node2 = new ListNode(5, node1);
        ListNode node3 = new ListNode(4, node2);
        ListNode node4 = new ListNode(3, node3);
        ListNode node5 = new ListNode(6, node4);
        ListNode node6 = new ListNode(2, node5);
        ListNode node7 = new ListNode(1, node6);
        PrintUtil.print(node7);
        Day24ReverseLink206 reverseLink206 = new Day24ReverseLink206();
        ListNode newhead = reverseLink206.reverseList(node7);
        PrintUtil.print(newhead);

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


}
