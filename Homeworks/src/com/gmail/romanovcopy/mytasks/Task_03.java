package com.gmail.romanovcopy.mytasks;

/*Реализовать простой калькулятор*/

import java.util.Scanner;
import java.util.Arrays;


public class Task_03 {
	
	Scanner scanner;
	char[]operations;
	boolean exit;
	
	
	public Task_03() {
		scanner=new Scanner(System.in);
		operations = new char[] { '+', '-', '*', '/'};
		exit=false;
		while(!exit) {
			System.out.print("Введите первое число :");
			double val1=getValue();
			System.out.print("Введите оператор ( +, -, *, / ) :");
			char operator=getOperator();
			System.out.print("Введите второе число : ");
			double val2=getValue();
			System.out.printf("%f %c %f = %f\n",  val1, operator, val2, execute(val1, val2, operator));
			System.out.print("Продолжить? (1 - да, 0 - нет)");
			exit=getValue()==0;
		}
	}
	
	private double getValue() {
		if(scanner.hasNextDouble())
		     return scanner.nextDouble();
		else
			return 0;
	}
	
	private char getOperator() {
		return scanner.next().charAt(0);		
	}
	
	
	private double execute(double val1, double val2, char operator) {
		double result=0;
		switch (operator) {
		case '+': 
			result=val1+val2;
			break;
		case '-':
			result=val1-val2;
			break;
		case '*':
			result=val1*val2;
			break;
		case '/':
			result=val2!=0?val1/val2:0;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + operator);
		}
		return result;
	}

}
