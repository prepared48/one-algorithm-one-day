package com.prepared.leetcode.string;


/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 */
public class Day38LeftHandString58 {

    public static void main(String[] args) {
        Day38LeftHandString58 handString58 = new Day38LeftHandString58();

        String s = "abcdefg";
        int k = 2;

        System.out.println(handString58.reverseLeftWords(s, k));
    }

    public String reverseLeftWords(String s, int n) {
        String newStr = s.substring(0, n);
        return s.concat(newStr).substring(n);
    }
}
