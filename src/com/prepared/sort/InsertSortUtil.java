package com.prepared.sort;

/**
 * 插入排序
 *
 * @Author: zhongshibo
 * @Date: 2021/2/3 17:51
 */
public class InsertSortUtil {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertSort(int arr[]) {
        for(int i = 0; i < arr.length; i++) {

        }
    }
}
