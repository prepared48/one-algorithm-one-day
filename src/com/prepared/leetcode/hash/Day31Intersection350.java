package com.prepared.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.prepared.baseutil.PrintUtil;

/**
 * 350. 两个数组的交集 II
 *
 * @Author: zhongshibo
 * @Date: 2021/6/10 17:30
 */
public class Day31Intersection350 {

    public static void main(String[] args) {
        Day31Intersection350 intersection350 = new Day31Intersection350();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
//        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
//        int[] nums1 = {1}, nums2 = {1, 1};
        int[] intersect = intersection350.intersect(nums1, nums2);
        PrintUtil.print(intersect);
    }

    /**
     * 把短的数组存储map, value为出现的次数
     * 遍历长的数组，如果map中有，存入结果中，map中对应key的value-1，如果value-1==0，直接删除key
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            int count = countMap.getOrDefault(nums1[i], 0) + 1;
            countMap.put(nums1[i], count);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for(int i = 0; i < nums2.length; i++) {
            if(countMap.get(nums2[i]) != null) {
                if(countMap.get(nums2[i]) - 1 == 0) {
                    res[index++] = nums2[i];
                    countMap.remove(nums2[i]);
                }else {
                    res[index++] = nums2[i];
                    countMap.put(nums2[i], countMap.get(nums2[i]) - 1);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }


}
