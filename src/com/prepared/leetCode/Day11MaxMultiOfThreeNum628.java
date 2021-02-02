package com.prepared.leetCode;

import com.prepared.baseutil.PrintUtil;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * @Author: zhongshibo
 * @Date: 2021/1/20 14:40
 */
public class Day11MaxMultiOfThreeNum628 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6};
//        int result = maximumProduct(nums);
//        System.out.println(result);
        PrintUtil.print(nums);
    }

    public static int maximumProduct(int[] nums) {
        // 排序
        Arrays.sort(nums);
        PrintUtil.print(nums);
        return Math.max(nums[nums.length - 3] * nums[nums.length - 1] * nums[nums.length - 2], nums[0] * nums[1] * nums[nums.length - 1]);
    }

    public static int maximumProduct2(int[] nums) {
        // 找出最大的 3 个数相乘
        int k1 = 3;
        // 最小的 2 个数 和 最大的一个数
        int k2 = nums.length - 2;
        return 0;
    }



}
