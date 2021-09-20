package com.prepared.leetcode.array;

import java.util.ArrayList;
import java.util.List;

import com.prepared.baseutil.PrintUtil;

/**
 * 54. 螺旋矩阵
 *
 * @Author: zhongshibo
 * @Date: 2021/5/24 15:31
 */
public class Day22SpiralMatrix54 {

    public static void main(String[] args) {
        Day22SpiralMatrix54 spiralMatrix54 = new Day22SpiralMatrix54();
         int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//         int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
//         int[][] nums = {{1}};
//        int[][] nums = {{6, 9, 7}};
        List<Integer> res = spiralMatrix54.spiralOrder(nums);
        PrintUtil.print(res);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int min = m > n ? n : m;
        int loop = (min % 2 == 0) ? (min / 2) : (min / 2 + 1);
        int startx = 0;
        int starty = 0;
        int offset = 1;
        int numEle = matrix.length * matrix[0].length;
        while (loop > 0 && numEle > 0) {
            int i = startx;
            int j = starty;
            if (j == starty + n - offset && i == startx + m - offset && numEle >= 1) {
                res.add(matrix[i][i]);
                numEle--;
            }
            // 上侧 从左到右
            for (; j < starty + n - offset && numEle >= 1; j++) {
                res.add(matrix[startx][j]);
                numEle--;
            }
            // 右侧，从上到下
            for (; i < startx + m - offset && numEle >= 1; i++) {
                res.add(matrix[i][j]);
                numEle--;
            }

            // 下侧 从右到左
            for (; j > starty && numEle >= 1; j--) {
                res.add(matrix[i][j]);
                numEle--;
            }
            // 左侧，从下到上
            for (; i > startx && numEle >= 1; i--) {
                res.add(matrix[i][j]);
                numEle--;
            }
            loop--;
            startx += 1;
            starty += 1;
            offset += 2;
        }
        
        return res;
    }
}
