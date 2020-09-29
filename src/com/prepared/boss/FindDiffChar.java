package com.prepared.boss;

/**
 * 给定的两个字符数组中，除了一个字符不同，其余字母的值和顺序都相同，假设第一个数组比第二个数组多一个字符，如何高效找到这个字符
 *
 * @Author: zhongshibo
 * @Date: 2020/9/29 09:50
 */
public class FindDiffChar {

	public static char find(char[] chars1, char[] chars2) {
		char diff = 0;
		for (int i = 0; i < chars1.length; i++) {
			if (chars1[i] != chars2[i]) {
				diff = chars1[i];
				break;
			}
		}
		return diff;
	}

	public static void main(String[] args) {
		char[] chars1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		char[] chars2 = {'a', 'b', 'c', 'd', 'f', 'g'};
		char diff = find(chars1, chars2);
		System.out.println(diff);
	}
}
