package com.prepared.leetCode;

/**
 * 35. 搜索插入位置
 *
 * @Author: zhongshibo
 * @Date: 2021/5/10 17:17
 */
public class Day17SearchInsertPos35 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        Day17SearchInsertPos35 insertPos35 = new Day17SearchInsertPos35();
        System.out.println(insertPos35.searchInsert(nums, target));
    }

    /**
     * 问题转化：查找第一个大于等于target的下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int t = nums.length - 1;
        int mid = 0;
        int index = nums.length;
        while (s <= t) {
            mid = s + ((t - s) >> 1) ;
            if (target <= nums[mid]) {
                index = mid;
                t = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return index;
    }

}
