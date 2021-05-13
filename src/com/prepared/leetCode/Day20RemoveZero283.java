package com.prepared.leetCode;

import com.prepared.baseutil.PrintUtil;

/**
 * 283. 移动零
 *
 * @Author: zhongshibo
 * @Date: 2021/5/13 14:21
 */
public class Day20RemoveZero283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Day20RemoveZero283 zero283 = new Day20RemoveZero283();
        zero283.moveZeroes(nums);
        PrintUtil.print(nums);
    }

    /**
     * 双指针法
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < j && j < nums.length) {
            if(nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }else if(nums[i] != 0) {
                i++;
                j++;
            }else if(nums[i] == 0 && nums[j] == 0) {
                j++;
            }
        }
    }
}
