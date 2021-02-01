package com.prepared.leetCode;

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
        int[] nums = {1,2,3,4};
        int result = maximumProduct(nums);
        System.out.println(result);
    }

    public static int maximumProduct(int[] nums) {
        // 排序
        Arrays.sort(nums);
        print(nums);
        return Math.max(nums[nums.length - 3]*nums[nums.length-1]*nums[nums.length-2], nums[0]*nums[1]*nums[nums.length-1]);
    }

    public static void print(int [] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }
}
