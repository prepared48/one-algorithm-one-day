package com.prepared.leetcode.array;


/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 */
public class Day36IntRevese7 {

    public static void main(String[] args) {
        Day36IntRevese7 intRevese7 = new Day36IntRevese7();
        int res = intRevese7.reverse(1534236469);
        System.out.println(res);
    }


    /**
     * 从各位开始获取每一位，之后相加
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    /**
     * 转成数组再处理
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int len = 0;
        if(x <  0) {
            len = String.valueOf(x).length() - 1;
        }else {
            len = String.valueOf(x).length();
        }
        int y = Math.abs(x);
        int[] arr = new int[len];
        int i = 0;
        while(y > 0 ) {
            arr[i] = y % 10;
            y = y / 10;
            i++;
        }
        StringBuilder res = new StringBuilder();
        if(x < 0) {
            res.append("-");
        }
        for(int j = 0; j < arr.length; j++) {
            res.append(arr[j]);
        }
        try {
            return Integer.valueOf(res.toString());
        }catch (Exception e) {
            return 0;
        }

    }
}
