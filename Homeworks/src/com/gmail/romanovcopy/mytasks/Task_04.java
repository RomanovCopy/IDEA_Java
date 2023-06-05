package com.gmail.romanovcopy.mytasks;

/*Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства.
Знаки вопроса - одинаковые цифры.
Предложить хотя бы одно решение или сообщить, что его нет.*/

import java.util.Scanner;

public class Task_04 {
	
	public Task_04() {
        search(inputEquation());	
	}
	
	//ввод уравнения
	private String inputEquation() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Введите уравнение: ");
        return scanner.nextLine();
	}
	
	//поиск и вывод вариантов
	private void search(String equation ) {
		// Разбиваем уравнение на три части
        String[] parts = equation.split("=");
        var left = parts[0].trim();
        var right = parts[1].trim();
        int result = Integer.parseInt(right);
        
        // Находим знаки вопроса и создаем массив возможных значений для них
        char[] questionMarks = left.replaceAll("[^?]", "").toCharArray();
        int[] possibleValues = new int[10];
        for (int i = 0; i < 10; i++) {
            possibleValues[i] = i;
        }
        
        // Перебираем все возможные комбинации цифр для знаков вопроса
        for (int i = 0; i < Math.pow(10, questionMarks.length); i++) {
            int[] values = new int[questionMarks.length];
            int temp = i;
            for (int j = questionMarks.length - 1; j >= 0; j--) {
                values[j] = possibleValues[temp % 10];
                temp /= 10;
            }
            
         // Подставляем комбинацию цифр в уравнение
            String tempEquation = left;
            for (int j = 0; j < questionMarks.length; j++) {
                tempEquation = tempEquation.replaceFirst("\\?", Integer.toString(values[j]));
            }
            int tempResult = Integer.parseInt(tempEquation.split("\\+")[0].trim()) +
                    Integer.parseInt(tempEquation.split("\\+")[1].split("=")[0].trim());
            
            // Если полученное выражение равно результату, выводим его на экран
            if (tempResult == result) {
                System.out.println("Решение: " + tempEquation + " = " + result);
            }
        }
	}
	

}
