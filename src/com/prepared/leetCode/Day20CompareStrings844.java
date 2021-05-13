package com.prepared.leetCode;

/**
 * 844. 比较含退格的字符串
 *
 * @Author: zhongshibo
 * @Date: 2021/5/13 14:35
 */
public class Day20CompareStrings844 {

    public static void main(String[] args) {

        String S = "ab#c";
        String T = "ad#c";
        // System.out.println("#".compareTo(String.valueOf(S.charAt(2))));
        Day20CompareStrings844 compareStrings844 = new Day20CompareStrings844();
        boolean flag = compareStrings844.backspaceCompare(S, T);
        System.out.println(flag);
        // System.out.println(compareStrings844.getAfterStr(S));
        // System.out.println(compareStrings844.getAfterStr(T));
    }

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        // 倒序 比较每个需要比较的字符
        while (i >= 0 || j >= 0) {
            // 找到需要比较的下一个字符，如果有#符号，跳过该字符以及前一个字符
            while (i >= 0) {
                if ("#".compareTo(String.valueOf(s.charAt(i))) == 0) {
                    skipS++;
                    i--;
                } else if(skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if ("#".compareTo(String.valueOf(t.charAt(j))) == 0) {
                    skipT++;
                    j--;
                }else if(skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if(i >= 0 && j >= 0) {
                if(s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            }else {
                if(i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
