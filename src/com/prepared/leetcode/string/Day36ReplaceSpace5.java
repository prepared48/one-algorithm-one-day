package com.prepared.leetcode.string;


/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 */
public class Day36ReplaceSpace5 {

    public static void main(String[] args) {
        String  s = "We are happy.";
        Day36ReplaceSpace5 replaceSpace5 = new Day36ReplaceSpace5();
        String res = replaceSpace5.replaceSpace(s);
        System.out.println(res);
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(" ".equals(String.valueOf(chars[i]))) {
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

}
