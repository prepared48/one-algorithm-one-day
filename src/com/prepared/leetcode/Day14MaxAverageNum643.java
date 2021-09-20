package com.prepared.leetcode;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * @Author: zhongshibo
 * @Date: 2021/2/4 10:54
 */
public class Day14MaxAverageNum643 {

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double res = findMaxAverage2(nums, k);
        System.out.println(res);
    }

    public static double findMaxAverage2(int[] nums, int k) {
        double res;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = (sum + 0.0) / k;
        for(int i = k; i < nums.length; i++) {
            sum = (sum - nums[i-k]) + nums[i];
            res = (sum + 0.0)/ k;
            max = Math.max(res, max);
        }
        return max;
    }
    /**
     * 找出最大的子数组的平均数
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        double res;
        // 注意点
        double max = Double.NEGATIVE_INFINITY;
        int sum = 0;
        for(int i = 0; i <= nums.length - k; i++) {
            if(i == 0) {
                sum = calculateSum(nums, i, i + k);
            }else {
                sum = (sum - nums[i-1]) + nums[i+k-1];
            }
            res = (sum + 0.0)/ k;
            if(res > max) {
                max = res;
            }
        }
        return max;
    }

    /**
     * 计算子数组的和
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int calculateSum(int[] nums, int start, int end) {
        int sum = 0;
        for(int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 计算平均数--可以优化。有重复计算的内容
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static double calculateAverage(int[] nums, int start, int end) {
        int sum = 0;
        for(int i = start; i < end; i++) {
            sum += nums[i];
        }
        return (sum + 0.0)/ (end - start);
    }
}
