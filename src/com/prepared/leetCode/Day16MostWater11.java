package com.prepared.leetCode;

/**
 * 盛最多水的容器
 *
 * @Author: zhongshibo
 * @Date: 2021/5/8 16:53
 */
public class Day16MostWater11 {

    public static void main(String[] args) {
        int[] height = {
                1,8,6,2,5,4,8,3,7
            };
        Day16MostWater11 mostWater = new Day16MostWater11();
        System.out.println(mostWater.maxArea2(height));
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int s = 0;
        int t = height.length - 1;
        int max = 0;
        int cur = 0;
        while (s < t) {
            cur = (t - s) * Math.min(height[s], height[t]);
            if(cur > max) {
                max = cur;
            }
            if(height[s] > height[t]) {
                t--;
            }else {
                s++;
            }
        }
        return max;
    }

    /**
     * 暴力破解 超时
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int len = height.length;
        int[] w = calcW(height, len);
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            if(w[i] > max) {
                max = w[i];
            }
        }
        return max;
    }

    public int[] calcW(int[] height, int len) {
        int[] w = new int[len];
        int max = 0;
        int cur = 0;
        // 包含 i 的时候 最大值
        for(int i = len - 1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                cur = (i - j) * Math.min(height[i], height[j]);
                if (cur > max) {
                    max = cur;
                }
            }
            w[i] = max;
            max = 0;
        }
        return w;
    }
}
