package com.prepared.leetcode.LinkedList;

/**
 * 203. 移除链表元素
 *
 * @Author: zhongshibo
 * @Date: 2021/5/24 16:48
 */
public class Day22RemoveEle203 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(6, null);
        ListNode node2 = new ListNode(5, node1);
        ListNode node3 = new ListNode(4, node2);
        ListNode node4 = new ListNode(3, node3);
        ListNode node5 = new ListNode(6, node4);
        ListNode node6 = new ListNode(2, node5);
        ListNode node7 = new ListNode(1, node6);
        Day22RemoveEle203 removeEle203 = new Day22RemoveEle203();
        ListNode listNode = removeEle203.removeElements(node7, 6);
        System.out.println(listNode.val);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, curr = head;

        while (curr != null) {
            if(curr.val == val) {
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
