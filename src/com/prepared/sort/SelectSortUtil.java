package com.prepared.sort;

import com.prepared.baseutil.PrintUtil;

/**
 * 不稳定排序
 * 时间复杂度：最好O(n^2) 最差O(n^2) 平均O(n^2)
 *
 * @Author: zhongshibo
 * @Date: 2021/2/4 10:53
 */
public class SelectSortUtil {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6};
        selectSort(nums, nums.length);
        PrintUtil.print(nums);
    }

    /**
     * 选择排序
     * 从0到n-1，找出未排序数组中最小的，和i交换
     *
     * @param nums
     * @param n
     */
    public static void selectSort(int[] nums, int n) {
        for(int i = 0; i < n; i++) {
            int min = nums[i];
            int k = 0;
            for(int j = i; j < n; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    k = j;
                }
            }
            if(k > i) {
                // 交换 i 和 k
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
