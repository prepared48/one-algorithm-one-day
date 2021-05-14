package com.prepared.leetCode.array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @Author: zhongshibo
 * @Date: 2021/5/10 17:58
 */
public class Day17SearchFirLasPos34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        Day17SearchFirLasPos34 pos34 = new Day17SearchFirLasPos34();
//        int[] res = pos34.searchRange(nums, target);
//        System.out.println(res[0] + ": " + res[1]);
        int leftIdx = pos34.searchFirst(nums, target);
        int rightIdx = pos34.searchLast(nums, target);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            System.out.println(new int[] {leftIdx, rightIdx});
        }else {
            System.out.println(new int[] {-1, -1});
        }
        System.out.println(leftIdx);
        System.out.println(rightIdx);
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[] {leftIdx, rightIdx};
        }
        return new int[] {-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int s = 0;
        int t = nums.length - 1;
        int mid = 0;
        int index = nums.length;
        while (s <= t) {
            mid = s + ((t - s) >> 1);
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                t = mid - 1;
                index = mid;
            } else {
                s = mid + 1;
            }
        }
        return index;
    }

    public int searchFirst(int[] nums, int target) {
        int s = 0;
        int t = nums.length - 1;
        int mid = 0;
        int index = nums.length;
        while (s <= t) {
            mid = s + ((t - s) >> 1) ;
            if (target <= nums[mid]) {
                index = mid;
                t = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return index;
    }

    public int searchLast(int[] nums, int target) {
        int s = 0;
        int t = nums.length - 1;
        int mid = 0;
        int index = 0;
        while (s <= t) {
            mid = s + ((t - s) >> 1) ;
            if (target >= nums[mid]) {
                index = mid;
                s = mid + 1;
            } else {
                t = mid - 1;
            }
        }
        return index;
    }
}
