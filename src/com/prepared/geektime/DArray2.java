package com.prepared.geektime;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 *
 * @Author: zhongshibo
 * @Date: 2020/09/02 08:37
 */
public class DArray2 {

	private String[] data;

	private int count;

	//	容量
	private int capacity;

	public DArray2(String[] data, int count, int capacity) {
		this.data = data;
		this.count = count;
		this.capacity = capacity;
	}

	/**
	 * 初始化数组构造方法——指定数组初始容量
	 *
	 * @param capacity
	 */
	public DArray2(int capacity) {
		this.data = new String[capacity];
		this.count = 0;
		this.capacity = capacity;
	}

	/**
	 * 往固定位置插入数据
	 *
	 * @param index 位置下标
	 * @param value 要插入的值
	 * @return
	 */
	public boolean insert(int index, String value) {
		if (count >= this.capacity) {
			System.out.println("空间不够了, 添加数据失败");
			return false;
		}
		if (index < 0 || index > count) {
			System.out.println("下标不对或者超过现有数据范围, 添加数据失败");
			return false;
		}
		for (int i = count - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		this.data[count] = value;
		count++;
		return false;
	}

	/**
	 * 删除数据
	 *
	 * @param index 下标
	 * @return
	 */
	public boolean delete(int index) {
		if (count == 0) {
			System.out.println("没有数据，不能删除");
			return false;
		}
		if (index < 0 || index > count) {
			System.out.println("该下标没有数据，不能删除");
			return false;
		}
		for (int i = index + 1; i <= count; i++) {
			data[i - 1] = data[i];
		}
		count--;
		System.out.println("删除成功");
		return true;
	}

	/**
	 * 往数组中添加数据
	 *
	 * @param value
	 * @return
	 */
	public boolean append(String value) {
		if (count >= this.capacity) {
			// 扩容
			System.out.println("空间不够了, 添加数据失败");
			return false;
		}
		this.data[count] = value;
		count++;
		return true;
	}

	public void printAllData() {
		//	循环打印数组中的数据
		for (int i = 0; i < count; i++) {
			System.out.print(data[i] + " ");
		}
		//	换行
		System.out.println();
	}

	public static void main(String[] args) {
		DArray2 dArray = new DArray2(4);
		dArray.append("hello");
		dArray.append("word");
		dArray.printAllData();
		System.out.println("扩容前，数组size = " + dArray.capacity);
		dArray.insert(2, " java ");
		dArray.printAllData();
		System.out.println("扩容后，数组size = " + dArray.capacity);
		//	删除数据
		dArray.delete(2);
		dArray.printAllData();
	}

}
