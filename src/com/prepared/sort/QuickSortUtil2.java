package com.prepared.sort;

import com.prepared.baseutil.PrintUtil;

/**
 * @Author: zhongshibo
 * @Date: 2021/2/3 15:25
 */
public class QuickSortUtil2 {

    public static void main(String[] args) {
        int[] nums = {1,3, -1};
        nums = quickSort(nums, 0, nums.length - 1);
        PrintUtil.print(nums);
    }

    public static int[] quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
        return arr;
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
