package com.prepared.sort;

import com.prepared.baseutil.PrintUtil;

/**
 * 快速排序util
 * 快速排序不是稳定的排序算法
 *
 * @Author: zhongshibo
 * @Date: 2021/2/1 16:20
 */
public class QuickSortUtil {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6, 8, 111, 10};
        partition(nums, 0, nums.length-1);
        PrintUtil.print(nums);
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public static void quickSort(int[] nums) {
        quickSortC(nums, 0, nums.length - 1);
    }

    /**
     * 制定起始终止位置的排序
     *
     * @param nums
     * @param p
     * @param r
     */
    public static void quickSortC(int[] nums, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(nums, p, r);
        quickSortC(nums, p, q - 1);
        quickSortC(nums, q + 1, r);
    }

    /**
     * 选取分区值，并进行一轮排序
     * 我们通过游标 i 把 A[p...r-1]分成两部分。A[p...i-1]的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，A[i...r-1]是“未处理区间”。
     * 我们每次都从未处理的区间 A[i...r-1]中取一个元素 A[j]，与 pivot 对比，如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i]的位置。
     *
     * @param nums
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        int temp;
        for (int j = p; j < r; j++) {
            if (nums[j] < pivot) {
                // 交换nums[i]和nums[j]
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i = i + 1;
            }
        }
        // 交换nums[i]和nums[r]
        temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        return r;
    }
}
