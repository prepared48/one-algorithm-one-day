package com.prepared.leetcode.string;

import com.prepared.baseutil.PrintUtil;

public class Day40RepeatedSubString459 {

    public static void main(String[] args) {
        Day40RepeatedSubString459 subString459 = new Day40RepeatedSubString459();

        String s = "abcabcabcabc";
        boolean flag = subString459.repeatedSubstringPattern(s);
        System.out.println(flag);
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(next, s);
        PrintUtil.print(next);

        if(s.length() %(s.length() - next[s.length() - 1] + 1) == 0) {
            return true;
        }
        return false;
    }

    public void getNext(int[] next, String s) {
        int length = s.length();
        int j = -1;
        next[0] = j;
        for(int i = 1; i < length; i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if(s.charAt(i) == s.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
    }
}
