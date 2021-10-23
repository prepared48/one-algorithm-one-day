package com.prepared.interview;

public class Baidu3 {

//   s1 = hell world s2 = yellow 最长共有字符串
// 字母 大小写、数字

    public static void main(String[] args) {
        String s1 = "hell word";
        String s2 = "yello  w";
        Baidu3 baidu3 = new Baidu3();
        int len = baidu3.maxCommonLen(s1, s2);
        System.out.println(len);
    }

    /**
     * 动态规划
     *
     * @param s1
     * @param s2
     * @return
     */
    public int maxCommonLen(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] res = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++) {
            char char1 = s1.charAt(i - 1);
            for(int j = 1; j < n + 1; j++) {
                char char2 = s2.charAt(j - 1);
                if(char1 == char2) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                }else {
                    res[i][j] = Math.max(res[i -1][j], res[i][j - 1]);
                }
            }
        }
        return res[m][n];
    }




}
