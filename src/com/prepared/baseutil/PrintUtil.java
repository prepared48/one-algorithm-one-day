package com.prepared.baseutil;

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
}
