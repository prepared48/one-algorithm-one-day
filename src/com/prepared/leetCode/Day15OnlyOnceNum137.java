package com.prepared.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * @Author: zhongshibo
 * @Date: 2021/4/30 17:15
 */
public class Day15OnlyOnceNum137 {

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(Objects.isNull(resultMap.get(nums[i]))) {
                resultMap.put(nums[i], 1);
            }else {
                resultMap.put(nums[i], resultMap.get(nums[i]) + 1);
            }
        }
        Set<Integer> integerSet = resultMap.keySet();
        for(Integer num : integerSet) {
            if(Objects.equals(resultMap.get(num), 1)) {
                return num;
            }
        }
        return 9999999;
    }
}
