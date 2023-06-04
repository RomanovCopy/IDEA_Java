package com.gmail.romanovcopy;

import java.util.Random;

/*Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.*/



public class _002 {

	
	
	public static void main(String[] args) {
		
		var array=createArray(100);
		System.out.print(maxTrue(array));
		
	}
	
	private static boolean[] createArray(int length) {
		Random rand=new Random();
		boolean[]list =new boolean[length];
		for(int i=0;i<length;i++) {
			list[i]=rand.nextInt(1)==1;
		}
		return list;
	}
	
	private static int maxTrue(boolean[]array) {
		int max=0;
		int count=0;
		for(boolean val:array) {
			if(val) {
				count++;
			}
			else {
				if(count>max) {
					max=count;
				}
				count=0;
			}
		}
		return max;
	}
	

}
