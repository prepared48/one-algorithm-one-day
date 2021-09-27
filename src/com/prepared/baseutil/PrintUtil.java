package com.prepared.baseutil;

import com.prepared.leetcode.LinkedList.ListNode;

import java.util.List;

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

    public static void print(char[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + ",");
        }
        System.out.println();
    }

    public static void print(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + ", ");
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
