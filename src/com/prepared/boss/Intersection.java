package com.prepared.boss;

import java.util.ArrayList;
import java.util.List;

/**
 * boss直聘笔试1：2个有序数组，找出其中的交集
 *
 * @Author: zhongshibo
 * @Date: 2020/9/29 09:29
 */
public class Intersection {

	public static int[] retainAll(int[] array1, int[] array2) {

		List<Integer> resultList = new ArrayList<>();
		int i = 0, j = 0, k = 0;
		while (i < array1.length && j < array2.length) {
			if (array1[i] == array2[j]) {
				resultList.add(array1[i]);
				i++;
				j++;
			} else if (array1[i] > array2[j]) {
				j++;
			} else {
				i++;
			}
		}
		int[] resultArray = new int[resultList.size()];
//		System.out.println(resultList.toString());
		int m = 0;
		for (k = 0; k < resultList.size(); k++) {
			resultArray[m++] = resultList.get(k);
		}
		return resultArray;
	}

	public static void main(String[] args) {
		int[] arrary1 = {1, 3, 4, 5, 6, 7};
		int[] arrary2 = {2, 4, 6, 7, 8, 9};
		int[] ints = retainAll(arrary1, arrary2);
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + ", ");
		}
	}
}
