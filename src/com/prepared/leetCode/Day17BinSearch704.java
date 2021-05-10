package com.prepared.leetCode;

/**
 * 问题：704 二分查找
 *
 * @Author: zhongshibo
 * @Date: 2021/5/10 17:01
 */
public class Day17BinSearch704 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 5;
        Day17BinSearch704 search704 = new Day17BinSearch704();
        System.out.println(search704.search2(nums, target));
    }

    /**
     * 官网解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int s = 0;
        int t = nums.length - 1;
        int mid = 0;
        while (s <= t) {
            mid = s + (t - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                t = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 自己解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int s = 0;
        int t = nums.length - 1;
        return searchBase(nums, s, t, target);
    }

    /**
     * 递归
     *
     * @param nums
     * @param s
     * @param t
     * @param target
     * @return
     */
    public int searchBase(int[] nums, int s, int t, int target) {
        if (s == t) {
            if (nums[s] == target) {
                return s;
            }
        }
        int mid = 0;
        while (s < t) {
            mid = (s + t) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return searchBase(nums, 0, mid - 1, target);
            } else if (nums[mid] < target) {
                return searchBase(nums, mid + 1, t, target);
            }
        }
        return -1;
    }
}
