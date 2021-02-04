package com.prepared.sort;

import com.prepared.baseutil.PrintUtil;

/**
 * 冒泡排序
 * 原地排序算法
 * 稳定性算法
 * 时间复杂度：最好O(n) 最差O(n^2) 平均O(n^2)
 *
 * @Author: zhongshibo
 * @Date: 2021/2/4 09:48
 */
public class BubbleSortUtil {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6};
        bubbleSort2(nums, nums.length);
        PrintUtil.print(nums);
    }

    /**
     * 冒泡排序--未优化
     *
     * @param arr
     * @param n
     */
    public static void bubbleSort(int[] arr, int n) {
        if(n <= 1) {
            return;
        }
        int temp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 优化
     *
     * @param arr
     * @param n
     */
    public static void bubbleSort2(int[] arr, int n) {
        if(n <= 1) {
            return;
        }
        int temp = 0;
        for(int i = 0; i < n; i++) {
            // 是否提前退出标志
            boolean flag = false;
            for(int j = 0; j < n - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }
}
