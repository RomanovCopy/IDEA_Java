package com.gmail.romanovcopy.mytasks;

/*Вывести все простые числа от 1 до 1000*/

public class Task_02 {
	
	public Task_02(int n) {
		//запуск вывода простых чисел
		System.out.println("Простые числа от 1 до " + n + ":");
		printPrimes(n);
	}
	
	//вывод простых чисел
	private void printPrimes(int n) {
		int count=1;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + "\t");//вывод с табуляцией
                if(count%10==0)//перенос строк для удобочитаемости
                	System.out.println();
                count++;
            }
        }
    }
	
	//является ли число простым
	private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
	

}

