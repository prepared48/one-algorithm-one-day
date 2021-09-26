package com.prepared.leetcode.hash;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 * @Author: zhongshibo
 * @Date: 2021/6/4 17:10
 */
public class Day29GroupAnagram49 {

    public static void main(String[] args) {
        String[] params = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Day29GroupAnagram49 groupAnagram49 = new Day29GroupAnagram49();
        List<List<String>> resList = groupAnagram49.groupAnagrams(params);

    }

    /**
     * 给每个字符串排序，排序后的字符串为key，原来的字符串为value
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        char[] array;
        String key;
        List<String> list;
        for(String str : strs) {
            array = str.toCharArray();
            Arrays.sort(array);
            key = new String(array);
            list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 出现字符+次数为key，原来的字符串为value
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] counts;
        int length;
        StringBuilder sb;
        String key;
        List<String> list;
        for(String str : strs) {
            counts = new int[26];
            length = str.length();
            for(int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                if(counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            key = sb.toString();
            list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
