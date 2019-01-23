package com.parepared.leetCode;

/**
 * max subarray
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class Day01MaximumSubarray53 {

    public static void main(String[] args) {

        int a [] = {-1,0,-1,2,-3,1,2,3,-2};

        System.out.println(maxSubArray(a));
    }


    /**
     * rule:
     * 1 max subarray is in the left half array
     * 2 max subarray is in the right half array
     * 3 max subarray is cross left half array and the right half array
     */

    public static int getMax(int[] nums, int s, int t) {
        if(s >= t) return nums[s];
        int m = (t - s)/2;
        int l = getMax(nums, s, s+m);
        int r = getMax(nums, s+m+1, t);

        int sum = nums[s+m] + nums[s+m+1];
        int max = sum;
        for(int i = s+m-1; i >= s; i--) {
            sum += nums[i];
            if(sum > max) {
                max = sum;
            }
        }
        sum = max;
        for(int j = s+m+2; j <= t; j++) {
            sum += nums[j];
            if(sum > max) max = sum;
        }
        return ((l>r?l:r)>max)?(l>r?l:r):max;

    }

    // 分治
    public static int maxSubArray(int[] nums) {
        int s = 0;
        int t = nums.length - 1;
        return getMax(nums, s, t);
    }



}
