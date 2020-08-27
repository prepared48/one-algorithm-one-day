package com.prepared.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @Author zhongshibo
 * @Date 2019/4/28
 * @Version 1.0
 **/
public class Day103Sum15 {

    public static void main(String[] args) {
        int [] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * 1、先排序；
     * from: https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi-1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    }else {
                        hi--;
                    }
                }
            }
        }
        return list;
    }
}
