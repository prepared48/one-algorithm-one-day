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
        int[] nums = {1,3, -1};
        int[] ints = quickSort(nums);
        PrintUtil.print(ints);
//        partition(nums, 0, 2);
//        PrintUtil.print(nums);
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public static int[] quickSort(int[] nums) {
        quickSortC(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 指定起始终止位置的排序
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
     *
     * 如果比pivot小，已处理区间加1，这个值放在这个位置
     *
     * @param nums
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] nums, int p, int r) {
       // 0...i,都是比pivot小的
        int i = (p - 1);
        int pivot = nums[r];
        for(int j = p; j < r; j++) {
            if(nums[j] <= pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // 交换pivot和num[i+1]
        int temp = nums[i+1];
        nums[i+1] = nums[r];
        nums[r] = temp;
        return i + 1;
    }
}
