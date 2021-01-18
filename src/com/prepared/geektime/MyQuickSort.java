package com.prepared.geektime;

import java.util.Random;

/**
 * 快速排序实现
 * <p>
 * 有三种优化方案
 *
 * @Author: zhongshibo
 * @Date: 2021/1/18 17:46
 */
public class MyQuickSort {

    public static void main(String[] args) {
        int[] arr = {26, 5, 10, 18, 27, 14};
//        arr[0] = arr[10];
        quickSort1(arr, 0, arr.length - 1);
        print(arr);

    }

    public static  void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();;
    }

    /**
     * 第一个位置为标记位
     * 缺点：可能人造数据使得时间复杂度为N^2
     *
     * @param arr
     * @param head
     * @param tail
     */
    private static void quickSort1(int[] arr, int head, int tail) {
        int low = head;
        int high = tail;
        int pivot = arr[low];
        if (low < high) {
            while (low < high) {
                while (low < high && pivot <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && pivot >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            if (low > head + 1) {
                quickSort1(arr, head, low - 1);
            }
            if (high < tail - 1) {
                quickSort1(arr, high + 1, tail);
            }
        }
    }

    private static int randomPivot(int head, int tail) {
        Random random = new Random();
        System.out.println(random.nextInt(tail) % (tail - head + 1) + head);
        return random.nextInt(tail) % (tail - head + 1) + head;
    }
}
