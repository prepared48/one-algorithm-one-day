package com.prepared.geektime;

/**
 * 支持动态扩容的数组
 *
 * @Author: zhongshibo
 * @Date: 2020/8/27 08:37
 */
public class DArray {

	private String[] data;

	private int count;

	//	容量
	private int capacity;

	public DArray(String[] data, int count, int capacity) {
		this.data = data;
		this.count = count;
		this.capacity = capacity;
	}

	/**
	 * 初始化数组构造方法——指定数组初始容量
	 *
	 * @param capacity
	 */
	public DArray(int capacity) {
		this.data = new String[capacity];
		this.count = 0;
		this.capacity = capacity;
	}

	/**
	 * 数组扩容
	 *
	 * @return
	 */
	public String[] expand() {
		if (count >= capacity) {
			String[] newArray = new String[this.capacity * 2];
			this.capacity = this.capacity * 2;
			// 数据copy到扩容后的数组
			for(int i = 0; i < count; i++) {
				newArray[i] = this.data[i];
			}
			return newArray;
		}else {
			return this.data;
		}
	}

	/**
	 * 往数组中添加数据
	 *
	 * @param value
	 * @return
	 */
	public boolean append(String value) {
		if(count >= this.capacity) {
 			// 扩容
			this.data = expand();
		}
		this.data[count] = value;
		count++;
		return true;
	}

	public void printAllData() {
		//	循环打印数组中的数据
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		//	换行
		System.out.println();
	}

	public static void main(String[] args) {
		DArray dArray = new DArray(2);
		dArray.append("hello");
		dArray.append("word");
		dArray.printAllData();
		System.out.println("扩容前，数组size = " + dArray.capacity);
		dArray.append(" java ");
		dArray.printAllData();
		System.out.println("扩容后，数组size = " + dArray.capacity);
	}

}
