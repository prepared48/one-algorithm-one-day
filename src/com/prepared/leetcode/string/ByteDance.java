package com.prepared.leetcode.string;

import com.prepared.baseutil.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串分段
 * 字符串S由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段，表示它能分成几段。
 * abcbcded
 * a | cbcb | ded
 * 可以分割成 3 段
 *
 */
public class ByteDance {

    public static void main(String[] args) {
        ByteDance byteDance = new ByteDance();
        String s = "abcbcded";
        List<Integer> func = byteDance.func(s);
        PrintUtil.print(func);
    }

    public List<Integer> func(String s) {
        int[] last = new int[26];
        int length = s.length();
        for(int i = 0; i < length; i++) {
            // 每个字母的最远距离
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;

        for(int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
