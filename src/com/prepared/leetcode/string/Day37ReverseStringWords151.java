package com.prepared.leetcode.string;

/**
 * 151. 翻转字符串里的单词
 *
 */
public class Day37ReverseStringWords151 {

    public static void main(String[] args) {
        Day37ReverseStringWords151 stringWords151 = new Day37ReverseStringWords151();

        String s = "a good  example";

        String res = stringWords151.reverseWords2(s);
        System.out.println(res);
    }


    /**
     * 进阶 空间复杂度 O（1）
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        StringBuilder sb = removeSpaces(s);
        // 反正整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 反转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end  = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private StringBuilder removeSpaces(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 移除首位多余空格
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();

        while (start <= end) {
            char c = s.charAt(start);
            if(c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     * 使用新的字符串
     * 时间复杂度o（N）
     * 空间复杂度O（N）
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i = s1.length - 1; i >= 0; i--) {
            if("".equals(s1[i])) continue;
            sb.append(s1[i]).append(" ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
