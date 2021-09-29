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
        String res = replaceSpace5.replaceSpace3(s);
        System.out.println(res);
    }


    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public String replaceSpace3(String s) {
        char[] arr = new char[s.length() * 3];

        int j = s.length() * 3 - 1;
        int i = s.length() - 1;
        int size = 0;
        while (i < j && i >= 0) {
            if(!" ".equals(String.valueOf(s.charAt(i)))) {
                arr[j] = s.charAt(i);
                j--;
                i--;
                size++;
            }else {
                arr[j] = '0';
                arr[j-1] = '2';
                arr[j-2] = '%';
                j -= 3;
                size += 3;
                i--;
            }
        }
        return new String(arr, s.length() * 3 - size, size);
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
