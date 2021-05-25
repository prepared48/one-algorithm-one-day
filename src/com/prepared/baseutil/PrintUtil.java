package com.prepared.baseutil;

import java.util.List;

import com.prepared.leetCode.LinkedList.ListNode;

/**
 * 打印数据util
 *
 * @Author: zhongshibo
 * @Date: 2021/2/1 16:11
 */
public class PrintUtil {

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static void print(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i));
        }
        System.out.println();
    }

    public static void print(int[][] nums, int n) {
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[] nums, int end) {
        for (int i = 0; i < end; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static void print(double[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }
        System.out.println();
    }
}
