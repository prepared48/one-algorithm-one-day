package com.prepared.leetCode;

import com.prepared.baseutil.PrintUtil;
import com.prepared.sort.QuickSortUtil2;

/**
 * 480. 滑动窗口中位数
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 * 该解法超时
 *
 * @Author: zhongshibo
 * @Date: 2021/2/3 14:27
 */
public class Day13SlideWindow480 {

    public static void main(String[] args) {
//        int[] nums = {1, 3, 4};
//        int k = 2;
//        int[] res = sort(nums, k);
//        PrintUtil.print(res);
        int[] cnums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] res = medianSlidingWindow(cnums, k);
        PrintUtil.print(res);
//        System.out.println(-2147483648+2147483647);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int m = 0;
        int[] klen = new int[k];
        int[] temp = new int[k];
        for(int i = 0; i < nums.length - k + 1; i++) {
            if( i != 0) {
                klen = sort(temp, nums[i+(k-1)]);
                temp = nosort(temp, nums[i+(k-1)]);
                res[m++] = getMedium(klen);
            }else {
                klen = getKLength(nums, k);
                temp = getKLength(klen, k);
                klen = QuickSortUtil2.quickSort(klen, 0, klen.length - 1);
                res[m++] = getMedium(klen);
            }
        }
        return res;
    }

    /**
     * 获取数组的前k个元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] getKLength(int[] nums, int k) {
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    /**
     * 有序数组，先删除第一个数，增加一个数字，之后排序。
     *
     * @param cnums 有序数组
     * @param num 新增数组
     * @return
     */
    public static int[] sort(int[] cnums, int num) {
        // 删除第一位数，把num增加到最后
        int[] re = new int[cnums.length];
        int m = 0;
        for(int j = 1; j < cnums.length; j++) {
            re[m++] = cnums[j];
        }
        re[m] = num;
//        QuickSortUtil2.quickSort(re, 0, re.length - 1);
        int temp = 0;
        int k = 0;
        for(int i = 0; i < re.length; i++) {
            if(re[i] > num) {
                temp = re[i];
                re[i] = num;
                k = i + 1;
                re[re.length-1] = temp;
            }
        }
        for(int n = k; n < re.length - 1; n++) {
            re[n] = re[n+1];
        }
        return re;
    }

    public static int[] nosort(int[] cnums, int num) {
        // 删除第一位数，把num增加到最后
        int[] re = new int[cnums.length];
        int m = 0;
        for(int j = 1; j < cnums.length; j++) {
            re[m++] = cnums[j];
        }
        re[m] = num;
        return re;
    }

    /**
     * 查找数组中的中位数
     *
     * @param cnums
     * @return
     */
    public static double getMedium(int[] cnums) {
        double medium = 0;
        if(cnums.length % 2 == 1) {
            medium = cnums[cnums.length / 2];
        }else {
            medium = (Double.valueOf(cnums[cnums.length / 2]) + Double.valueOf(cnums[cnums.length / 2 - 1]) + 0.0) / 2;
        }
//        System.out.println("=============");
//        PrintUtil.print(cnums);
//        System.out.println("中位数=" + medium);
        return medium;
    }
}
