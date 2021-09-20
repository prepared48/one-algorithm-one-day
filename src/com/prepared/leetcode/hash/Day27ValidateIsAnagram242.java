package com.prepared.leetcode.hash;

/**
 * 242. 有效的字母异位词
 *
 * @Author: zhongshibo
 * @Date: 2021/6/2 19:25
 */
public class Day27ValidateIsAnagram242 {

    public static void main(String[] args) {
        Day27ValidateIsAnagram242 isAnagram242 = new Day27ValidateIsAnagram242();
        String s = "rat", t = "cat";
        boolean flag = isAnagram242.isAnagram(s, t);
        System.out.println(flag);
    }

    /**
     * hash表方法
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for(int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a'] -= 1;
        }

        for(int i = 0; i < record.length; i++) {
            if(record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
