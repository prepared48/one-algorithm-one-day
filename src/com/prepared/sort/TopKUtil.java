package com.prepared.sort;

import com.prepared.baseutil.PrintUtil;

/**
 * 使用分治解决topK问题
 * 如果 p+1=K，那 A[p]就是要求解的元素；如果 K>p+1, 说明第 K 大元素出现在 A[p+1...n-1]区间，我们再按照上面的思路递归地在 A[p+1...n-1]这个区间内查找。
 * 同理，如果 K<p+1，那我们就在 A[0...p-1]区间查找。
 *
 * @Author: zhongshibo
 * @Date: 2021/2/1 17:40
 */
public class TopKUtil {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6};
        int[] res = topK(nums, 3);
        PrintUtil.print(res);
    }

    public static int[] topK(int[] nums, int k) {
        return topKC(nums, 0, nums.length - 1, k);
    }

    private static int[] topKC(int[] nums, int p, int r, int k) {
        int pivot = partition(nums, p, r);
        int[] temp = new int[k];
        if(pivot == k) {
            int m = 0;
            for (int i = 0; i < k; i++) {
                temp[m++] = nums[pivot + i];
            }
            return temp;
        }
        // TOPk 在 nums[pivot]-nums[r] 之间
        if( k > pivot) {
            return topKC(nums, 0, (r - pivot - 1), k);
        }else {
            return topKC(nums, (r - pivot) + 1, r, k);
        }
    }

    public static int partition(int[] nums, int p, int r) {
        if(p >= r) {
            return 0;
        }
        int pivot = nums[r];
        int i = p;
        int temp;
        for (int j = p; j < r; j++) {
            if (nums[j] < pivot) {
                // 交换nums[i]和nums[j]
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i = i + 1;
            }
        }
        // 交换nums[i]和nums[r]
        temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        PrintUtil.print(nums);
        System.out.println(">>>. (r - i): " + (r - i));
        return (r - i) >= 0 ? (r - i):0;
    }

}
