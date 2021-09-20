package com.prepared.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * leetcode problem 1:
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Day03TwoSum1 {

    /**
     * 暴力破解
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length && nums[i] <= target; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] hashMethod(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hashtable.containsKey(target-nums[i])) {
                return new int[] {hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int [] nums =  {2,7,11,15};
        int target = 9;
        int[] result = hashMethod(nums, target);
        for(int i = 0; i < result.length; i++) {
            System.out.print(i + ": " + result[i] + "; ");
        }
    }

}
