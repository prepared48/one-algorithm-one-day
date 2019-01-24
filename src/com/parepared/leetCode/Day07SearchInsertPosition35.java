package com.parepared.leetCode;


/**
 * leetcode problem 35:
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 */
public class Day07SearchInsertPosition35 {


    public static void main(String[] args) {

        int [] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert2(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int s = 0;
        int t = nums.length - 1;
        return searchInsert(nums, s, t, target);
    }

    /**
     * a better way from the website:
     * https://leetcode.com/problems/search-insert-position/discuss/224429/My-Java-solution-that-faster-than-100-users
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        while(l <= r){
            mid = (l+r)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid -1;
            }else{
                return mid;
            }
        }
        return l;
    }

    /**
     * use binarySearch
     * @param nums
     * @param s start index
     * @param t end index
     * @param target the element to insert
     * @return index
     */
    public static int searchInsert(int[] nums, int s, int t, int target) {
        if(s == t) {
            if(nums[s] < target) return s + 1;
            if(nums[s] == target) return s;
        }
        if(s < t) {
            int mid = (s + t)/2;
            if(nums[mid] == target) return mid;

            if(nums[mid] > target) {
                if(mid - 1 >=s && nums[mid-1] < target) return mid;
                return searchInsert(nums, s, mid - 1, target);
            }
            if(nums[mid] < target) {
                if(mid + 1 <= t && nums[mid + 1] > target) return mid+1;
                return searchInsert(nums, mid + 1, t, target);
            }
        }
        return 0;
    }

}
