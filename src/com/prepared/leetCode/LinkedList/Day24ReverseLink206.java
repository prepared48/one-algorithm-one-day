package com.prepared.leetCode.LinkedList;

/**
 * 206. 反转链表
 *
 * @Author: zhongshibo
 * @Date: 2021/5/25 11:12
 */
public class Day24ReverseLink206 {

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
