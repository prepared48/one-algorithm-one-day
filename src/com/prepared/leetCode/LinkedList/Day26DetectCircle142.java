package com.prepared.leetCode.LinkedList;

/**
 * 142. 环形链表 II
 *
 * @Author: zhongshibo
 * @Date: 2021/5/27 17:36
 */
public class Day26DetectCircle142 {

    public static void main(String[] args) {

        ListNode node2 = new ListNode(5);
        ListNode node1 = new ListNode(6, node2);
        node2.next = node1;
        ListNode node3 = new ListNode(4, node2);
        ListNode node4 = new ListNode(3, node3);
        ListNode node6 = new ListNode(2, node4);
        ListNode node7 = new ListNode(1, node6);
//        PrintUtil.print(node7);
        Day26DetectCircle142 detectCircle142 = new Day26DetectCircle142();
        ListNode node = detectCircle142.detectCycle(node7);
        if(node != null) {
            System.out.println("有环。。。");
            System.out.println(node.val);
            System.out.println(node.next.val);
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果有环
            if (slow == fast) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
