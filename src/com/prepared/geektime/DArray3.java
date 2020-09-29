package com.prepared.geektime;

/**
 * 实现两个有序数组合并为一个有序数组
 *
 * @Author: zhongshibo
 * @Date: 2020/09/02 08:37
 */
public class DArray3 {

	/**
	 * 实现两个有序数组合并为一个有序数组
	 *
	 * @param array1
	 * @param array2
	 * @return
	 */
	public DArray2 mergeArray(DArray2 array1, DArray2 array2) {
		for (int i = 0; i < array1.getCapacity(); i++) {
			for (int j = 0; j < array2.getCapacity(); j++) {
				if (array1.getData()[i] > array2.getData()[j]) {

				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		DArray2 dArray = new DArray2(4);
		DArray2 dArray2 = new DArray2(3);
		dArray.append(1);
		dArray.append(4);
		dArray.insert(2, 6);
		dArray.insert(3, 8);
		dArray.printAllData();

		dArray2.append(2);
		dArray2.append(3);
		dArray2.append(7);

	}

}
