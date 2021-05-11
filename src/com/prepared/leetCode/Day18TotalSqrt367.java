package com.prepared.leetCode;

/**
 * 367. 有效的完全平方数
 *
 * @Author: zhongshibo
 * @Date: 2021/5/11 11:01
 */
public class Day18TotalSqrt367 {

    public static void main(String[] args) {
        Day18TotalSqrt367 sqrt367 = new Day18TotalSqrt367();
        boolean res = sqrt367.isPerfectSquare(16);
        System.out.println(res);
    }

    public boolean isPerfectSquare(int num) {
        int s = 0, t = num, mid = 0;
        boolean res = false;
        while (s <= t) {
            mid = s + ((t - s) >> 1);
            if(mid * mid == num) {
                res = true;
                return res;
            }else if( mid * mid < num) {
                s = mid + 1;
            }else {
                t = mid - 1;
            }
        }
        return res;
    }
}
