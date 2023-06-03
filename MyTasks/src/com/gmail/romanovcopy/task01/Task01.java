package com.gmail.romanovcopy.task01;

import java.util.Random;

public class Task01 {
	
	private static int[]array;

	public static void main(String[] args) {
		
		setArray(createArray(10));
		printArray(array);

	}
	
	private static int[] createArray(int length) {
		var list=new int [length];
		var rand=new Random();
		for(int i=0;i<list.length;i++) {
			list[i]=rand.nextInt(100);
		}
		return list;
	}
	

	
	private static void printArray(int[]array) {
		for(var item:array) {
			System.out.print(item+" ");
		}
	}

	public static int[] getArray() {
		return array;
	}

	public static void setArray(int[] array) {
		Task01.array = array;
	}

}
