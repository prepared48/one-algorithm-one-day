package com.prepared.sort;

import com.prepared.baseutil.PrintUtil;

/**
 * 归并排序
 * 归并排序是稳定的算法。
 * 归并排序不是原地排序方法，空间复杂度比较高
 *
 * @Author: zhongshibo
 * @Date: 2021/2/1 16:10
 */
public class MergeSortUtil {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6};
        mergeSort(nums);
        PrintUtil.print(nums);
    }

    /**
     * 归并排序
     *
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        mergeSortC(nums, 0, nums.length - 1);
    }

    public static void mergeSortC(int[] nums, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortC(nums, 0, q);
        mergeSortC(nums, q + 1, r);
        // 合并
        merge(nums, p, q, r);
    }

    /**
     * 归并排序 合并两个数组
     *
     * @param nums
     * @param p 起始位置
     * @param q 中间位置
     * @param r 终止位置
     */
    public static void merge(int[] nums, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = nums[start++];
        }
        for (int m = 0; m <= (r - p); m++) {
            nums[p + m] = temp[m];
        }
    }
}
