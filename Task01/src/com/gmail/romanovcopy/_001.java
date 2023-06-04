package com.gmail.romanovcopy;

//1) Написать программу, которая запросит пользователя ввести <Имя> в консоли. 
//Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”



import java.util.Scanner;

public class _001 {

	public static void main(String[] args) {
		System.out.print("Как Вас зовут? ");
		var myname=_001.input();
		System.out.printf("Привет!"+ myname);
	}
	
	private static String input() {
		var scanner=new Scanner(System.in);
		var text=scanner.nextLine();
		scanner.close();
		return text;
	}

}
