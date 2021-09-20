package com.prepared.leetcode.array;

import com.prepared.baseutil.PrintUtil;

/**
 * 977. 有序数组的平方 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * @Author: zhongshibo
 * @Date: 2021/5/13 16:54
 */
public class Day20ArraySqrt977 {

    public static void main(String[] args) {
        Day20ArraySqrt977 arraySqrt977 = new Day20ArraySqrt977();
        int[] nums = {-7,-3,2,3,11};
        int[] ints = arraySqrt977.sortedSquares(nums);
        PrintUtil.print(ints);
    }

    /**
     * 双指针法
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int j = nums.length - 1;
        int i = 0;
        int[] res = new int[nums.length];
        int k = nums.length - 1;
        while ( i <= j) {
            if (Math.pow(nums[i], 2) > Math.pow(nums[j], 2)) {
                res[k--] = (int)Math.pow(nums[i], 2);
                i++;
            } else {
                res[k--] = (int)Math.pow(nums[j], 2);
                j--;
            }
        }
        return res;
    }
}
