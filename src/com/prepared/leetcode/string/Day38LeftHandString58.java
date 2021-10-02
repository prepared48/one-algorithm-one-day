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

        System.out.println(handString58.reverseLeftWords2(s, k));
    }

    /**
     * 使用substring函数
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        String newStr = s.substring(0, n);
        return s.concat(newStr).substring(n);
    }

    /**
     * 1.反转区间为前n的子串
     * 2.反转区间为n到末尾的子串
     * 3.反转整个字符串
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, s.length() - 1);
        reverseString(sb, 0, sb.length() - 1);
        return sb.toString();
    }

    public void reverseString(StringBuilder sb, int begin, int end) {
        while (begin < end) {
            char tmp = sb.charAt(begin);
            sb.setCharAt(begin, sb.charAt(end));
            sb.setCharAt(end, tmp);
            begin++;
            end--;
        }
    }
}
