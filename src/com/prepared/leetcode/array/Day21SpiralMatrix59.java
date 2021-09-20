package com.prepared.leetcode.array;

import com.prepared.baseutil.PrintUtil;

/**
 * 59. 螺旋矩阵 II
 *
 * @Author: zhongshibo
 * @Date: 2021/5/14 15:44
 */
public class Day21SpiralMatrix59 {

    public static void main(String[] args) {
        Day21SpiralMatrix59 spiralMatrix59 = new Day21SpiralMatrix59();
        int n = 4;
        int[][] nums = spiralMatrix59.generateMatrix(n);
        PrintUtil.print(nums, n);
    }

    /**
     * 四个方向：从左到右，从上到下，从右到左，从下到上
     * 固定为左闭右开
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = n / 2;
        int startx = 0;
        int starty = 0;
        int offset = 1;
        int count = 1;
        int mid = n / 2;

        while (loop > 0) {
            int i = startx;
            int j = starty;
            // 上侧 从左到右
            for(; j < starty + n - offset; j++) {
                res[startx][j] = count++;
            }
            // 右侧，从上到下
            for(; i < startx + n - offset; i++) {
                res[i][j] = count++;
            }
            // 下侧 从右到左
            for(; j > starty; j--) {
                res[i][j] = count++;
            }
            // 左侧，从下到上
            for(; i > startx; i--) {
                res[i][j] = count++;
            }
            loop--;
            startx += 1;
            starty += 1;
            offset += 2;
        }
        if(n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }
}
