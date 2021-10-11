package com.prepared.leetcode.string;

import com.prepared.baseutil.PrintUtil;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 */
public class Day39StrFunc28 {

    public static void main(String[] args) {
        Day39StrFunc28 strFunc28 = new Day39StrFunc28();
        String haystack = "aabaabaafa", needle = "aabaaf";
//        int res = strFunc28.strStr2(haystack, needle);
//        System.out.println(res);
        String s = "abcabcabcabc";
        int[] next = new int[s.length()];
        strFunc28.getNext(next, s);
        PrintUtil.print(next);
    }


    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }



    /**
     * KMP 算法解决 时间复杂度 O(m+n)
     * m = haystack.length() n = needle.length()
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }

        int[] next  = new int[needle.length()];

        getNext(next, needle);
        int j = -1;
        for(int i = 0; i < haystack.length(); i++) {
            System.out.println("i = " + i + " & j = " + j);
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                // 跳过最长公共前后缀个字符
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j+1)) {
                j++;
            }
            // 匹配完needle字符，返回位置
            if(j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    /**
     * 获取next数组。不加1
     *
     * @param next
     * @param s
     */
    public void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for(int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
                j = next[j];
            }
            if(s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }


}
