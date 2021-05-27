package com.prepared.leetCode.LinkedList;

import com.prepared.baseutil.PrintUtil;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @Author: zhongshibo
 * @Date: 2021/5/26 11:05
 */
public class Day25RemoveLastN19 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(6, null);
        ListNode node2 = new ListNode(5, node1);
        ListNode node3 = new ListNode(4, node2);
        ListNode node4 = new ListNode(3, node3);
        ListNode node6 = new ListNode(2, null);
        ListNode node7 = new ListNode(1, node6);
        PrintUtil.print(node7);
        Day25RemoveLastN19 removeLastN19 = new Day25RemoveLastN19();
        ListNode newHead = removeLastN19.removeNthFromEnd(node7, 2);
        PrintUtil.print(newHead);
    }

    /**
     * 双指针法，fast提前走n步
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(0);
        ListNode slow = head;
        prev.next = slow;
        int i = n;
        ListNode fast = head;
        while (i > 0) {
            fast = fast.next;
            i--;
        }
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        if(slow == head) {
            return head.next;
        }else {
            return head;
        }
    }
}
