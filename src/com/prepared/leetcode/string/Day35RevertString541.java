package com.prepared.leetcode.string;

/**
 * 344. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 1）如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 2）如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 *
 */
public class Day35RevertString541 {


    public static void main(String[] args) {
        Day35RevertString541 string344 = new Day35RevertString541();
        String s = "abcdefg";
        String s1 = string344.reverseStr(s, 8);
        System.out.println(s1);
    }


    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            // 交换[i, k]
            if(i + k <= s.length()) {
                result.append(reverseStr(s, i, i + k));
                if(i + 2 * k < s.length()) {
                    result.append(s.substring(i + k, i + 2 * k));
                }else {
                    result.append(s.substring(i + k, s.length()));
                }
                i += 2*k;
            }else if(i + k > s.length() && i < s.length()) {
                result.append(reverseStr(s, i, s.length()));
                i += 2*k;
            }
        }
        return result.toString();
    }

    public String reverseStr(String s, int begin, int end) {
        String substring = "";
        if(begin < end) {
            substring = s.substring(begin, end);
        }else if(begin == end) {
            substring = String.valueOf(s.charAt(begin));
        }

        char[] chars = substring.toCharArray();
        reverseString(chars);

        return String.valueOf(chars);
    }

    public void reverseString(char[] s) {
        int i = 0;
        while (i < s.length / 2 ) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
            i++;
        }
    }
}
