package com.prepared.leetcode.string;

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
        String haystack = "hello", needle = "ll";
        int res = strFunc28.strStr(haystack, needle);
        System.out.println(res);
    }


    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
