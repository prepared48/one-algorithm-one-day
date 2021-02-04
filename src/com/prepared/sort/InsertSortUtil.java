package com.prepared.sort;

import com.prepared.baseutil.PrintUtil;

/**
 * 插入排序
 *
 * @Author: zhongshibo
 * @Date: 2021/2/3 17:51
 */
public class InsertSortUtil {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6};
        insertSort(nums, nums.length);
        PrintUtil.print(nums);
    }

    /**
     * arr[i] 是将要排序的值
     * arr[0...i-1] 是已经排序好的值
     *
     * @param arr
     * @param n
     */
    public static void insertSort(int[] arr, int n) {
        if(n <= 1) {
            return;
        }
        for(int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for(; j >= 0; j--) {
                // 数据移动
                if(arr[j] > value) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            // 数据交换
            arr[j+1] = value;
        }
    }


}
