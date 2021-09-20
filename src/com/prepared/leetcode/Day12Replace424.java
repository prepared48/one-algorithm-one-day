package com.prepared.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 424. 替换后的最长重复字符
 *
 * @Author: zhongshibo
 * @Date: 2021/2/2 14:03
 */
public class Day12Replace424 {

    public static void main(String[] args) {
        String str = "AABABBA";
        int k = 1;
        System.out.println(maxLength2(str, k));
    }

    public static int maxLength2(String s, int k) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        int maxn = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            map.put(String.valueOf(s.charAt(right)), map.get(String.valueOf(s.charAt(right))) == null ? 1 : (map.get(String.valueOf(s.charAt(right)))) + 1);
            maxn = Math.max(maxn, map.get(String.valueOf(s.charAt(right))));
            if (right - left + 1 - maxn > k) {
                map.put(String.valueOf(s.charAt(left)), map.get(String.valueOf(s.charAt(left))) - 1);
                left++;
            }
            right++;
        }
        return right - left;
    }

    /**
     * 替换k次后的最长重复字符串
     *
     * @param str 原始字符
     * @param k   替换k次
     * @return
     */
    public static int maxLength(String str, int k) {
        int[] num = new int[26];
        int n = str.length();
        int maxn = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            num[str.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[str.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[str.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
