package com.prepared.leetcode.hash;

import java.util.ArrayList;
import java.util.List;

import com.prepared.baseutil.PrintUtil;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @Author: zhongshibo
 * @Date: 2021/6/9 17:25
 */
public class Day30FindAllAnagram438 {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        Day30FindAllAnagram438 allAnagram438 = new Day30FindAllAnagram438();
        List<Integer> anagrams = allAnagram438.findAnagrams2(s, p);
        PrintUtil.print(anagrams);
    }

    /**
     * 双指针滑动
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        int n = s.length(), m = p.length();
        if(n < m ) return resList;
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for(int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for(int right = 0; right < n; right++) {
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight] ++;
            while (sCnt[curRight] > pCnt[curRight]) {
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft] --;
                left ++;
            }
            if(right - left + 1 == m) {
                resList.add(left);
            }
        }
        return resList;
    }

    /**
     * 按照p的长度，逐个字符串判断
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (isAnagram(s.substring(i, i + p.length()), p)) {
                resList.add(i);
            }
        }
        return resList;
    }

    /**
     * hash表方法
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a'] -= 1;
        }

        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
