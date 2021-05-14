package com.prepared.leetCode.array;

import com.prepared.baseutil.PrintUtil;

/**
 * 27. 移除元素
 *
 * @Author: zhongshibo
 * @Date: 2021/5/12 17:58
 */
public class Day19RemoveData27 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Day19RemoveData27 day19RemoveData27 = new Day19RemoveData27();
        int res = day19RemoveData27.removeElement(nums, val);
        PrintUtil.print(nums, res);
        PrintUtil.print(nums);

    }

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
