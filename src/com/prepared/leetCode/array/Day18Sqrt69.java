package com.prepared.leetCode.array;

/**
 * 69. x 的平方根
 *
 * @Author: zhongshibo
 * @Date: 2021/5/11 10:16
 */
public class Day18Sqrt69 {

    public static void main(String[] args) {
        Day18Sqrt69 sqrt69 = new Day18Sqrt69();
        int x = 2147395600;
        int res = sqrt69.mySqrt2(x);
        System.out.println(res);
    }

    /**
     * 二分查找：查找 相乘  <= x 的最大值
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int s = 0, t = x, res = -1;
        while (s <= t) {
            int mid = s + ((t - s) / 2);
            if((long)mid * mid <= x) {
                res = mid;
                s = mid + 1;
            }else {
                t = mid - 1;
            }
        }
        return res;
    }

    /**
     * 转换为 e^1/2 * lnx
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

}
