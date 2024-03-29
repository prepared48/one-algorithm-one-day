package com.prepared.leetcode.string;

import com.prepared.baseutil.PrintUtil;

/**
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 */
public class Day34RevertString344 {


    public static void main(String[] args) {
        Day34RevertString344 string344 = new Day34RevertString344();
        char[] s = {'h', 'e', 'b', 'a'};
        string344.reverseString(s);
        PrintUtil.print(s);
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
