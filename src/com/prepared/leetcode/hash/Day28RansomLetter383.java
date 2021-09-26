package com.prepared.leetcode.hash;

/**
 * 383. 赎金信
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * @Author: zhongshibo
 * @Date: 2021/6/3 18:57
 */
public class Day28RansomLetter383 {

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        Day28RansomLetter383 ransomLetter383 = new Day28RansomLetter383();
        boolean flag = ransomLetter383.canConstruct(ransomNote, magazine);
        System.out.println(flag);
    }

    /**
     * 长度有限，使用数组 表示Hash表
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] noteArr = new int[26];
        for(int i = 0; i < ransomNote.length(); i++) {
            noteArr[ransomNote.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < magazine.length(); i++) {
            if(noteArr[magazine.charAt(i) - 'a'] >= 1) {
                noteArr[magazine.charAt(i) - 'a'] -= 1;
            }
        }

        for(int i = 0; i < noteArr.length; i++) {
            if(noteArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
