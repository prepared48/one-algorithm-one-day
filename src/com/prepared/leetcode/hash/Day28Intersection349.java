package com.prepared.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

import com.prepared.baseutil.PrintUtil;

/**
 * 349. 两个数组的交集
 *
 * @Author: zhongshibo
 * @Date: 2021/6/3 17:48
 */
public class Day28Intersection349 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Day28Intersection349 intersection347 = new Day28Intersection349();
        int[] res = intersection347.intersection(nums1, nums2);
        PrintUtil.print(res);
    }

    /**
     * 使用set，能自动去重
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++) {
            if(set1.contains(nums2[j])) {
                res.add(nums2[j]);
            }
        }
        int[] resArr = new int[res.size()];
        int index = 0;
        //将结果几何转为数组
        for (int i : res) {
            resArr[index++] = i;
        }
        return resArr;
    }
}
