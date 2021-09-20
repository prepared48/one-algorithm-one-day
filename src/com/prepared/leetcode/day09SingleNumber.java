package com.prepared.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description leetcode problem 136
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * @Author prepared
 **/
public class day09SingleNumber {

    /**
     * a method not so good
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map map = new HashMap();
        for(int i = 0; i < nums.length; i++) {

            if(map.containsKey(String.valueOf(nums[i]))){
                map.remove(String.valueOf(nums[i]));
            }else {
                map.put(String.valueOf(nums[i]), nums[i]);
            }
        }

        return (int)map.values().iterator().next();
    }

    public static void main(String[] args) {
        int [] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }
}
