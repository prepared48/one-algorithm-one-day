package com.prepared.leetCode;

import com.prepared.baseutil.PrintUtil;

/**
 * 26. 删除有序数组中的重复项
 *
 * @Author: zhongshibo
 * @Date: 2021/5/12 18:25
 */
public class Day19RemoveRepeatEle26 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Day19RemoveRepeatEle26 ele26 = new Day19RemoveRepeatEle26();
        int res = ele26.removeDuplicates(nums);
        System.out.println(res);
        PrintUtil.print(nums);
    }

    /**
     * 双指针法
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < j && j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            }else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i;
    }
}
