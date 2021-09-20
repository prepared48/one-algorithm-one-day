package com.prepared.leetcode;


import java.util.HashMap;
import java.util.Objects;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *
 * 掌上先机面试算法题
 */
public class Day32MissingNumber268 {

    public static void main(String[] args) {
        Day32MissingNumber268 missingNumber268 = new Day32MissingNumber268();
//        int[] nums = {3, 0, 1};
        int[] nums = { 0, 1};
        int num = missingNumber268.missingNumber3(nums);
        System.out.println(num);
    }

    /**
     * 时间复杂度 2 O(N)
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap();
        int max = nums.length;
        for(int i = 0; i < nums.length; i++) {
            hashMap.put(Integer.valueOf(nums[i]), 1);
        }

        for(int j = 0; j <= max; j++) {
            if(Objects.isNull(hashMap.get(Integer.valueOf(j)))) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 时间复杂度 O(N)
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int expectSum = nums.length * (nums.length + 1) / 2;

        int actualSum = 0;
        for(int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }
        return expectSum - actualSum;
    }

    /**
     * 0 ^ x = x
     * (a ^ a ^ b = b;
     *
     * 异或运算，时间复杂度 O(N)
     *
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int missing = nums.length;

        for(int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
