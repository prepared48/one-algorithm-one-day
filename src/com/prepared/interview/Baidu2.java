package com.prepared.interview;


import com.prepared.baseutil.PrintUtil;

public class Baidu2 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 8, 4, 6};
        Baidu2 baidu2 = new Baidu2();
        int[] ints = baidu2.quickSort(nums, 0, nums.length - 1);
        PrintUtil.print(ints);
    }

    public int[] quickSort(int[] nums, int left, int right) {
        quickSortC(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSortC(int[] nums, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = round(nums, p, r);
        quickSortC(nums, p, q - 1);
        quickSortC(nums, q + 1, r);
    }


    private static int round(int[] nums, int left, int right) {

        int offset = right;
        int newOffset = offset;
        int k = 0;
        for(int i = left; i < right - k; i++) {
            if(nums[i] > nums[offset]) {
                newOffset = i;
                int temp  = nums[right - k - 1];
                nums[right - k - 1] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
        int temp = nums[offset];
        nums[offset] = nums[newOffset];
        nums[newOffset] = temp;
        return newOffset;
    }
}
