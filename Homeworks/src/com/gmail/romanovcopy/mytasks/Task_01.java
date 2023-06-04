package com.gmail.romanovcopy.mytasks;

/* Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
 * n! (произведение чисел от 1 до n)*/

public class Task_01 {
	
	public Task_01( int n) {
		int sum=n*(n+1)/2;
		System.out.println("Сумма чисел от 1 до "+n+" равно "+sum);
		System.out.print("Произведение чисел от 1 до "+n+" равно "+factorial(n));
	}
	
	
	private int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
	}
	
}
