/*Реализовать консольное приложение, которое:

1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная была первой в выводе, а первая введённая - последней в выводе 
и чистит структуру
3. Выход - exit */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _030{
    public _030() {
        Deque<String> stack = new ArrayDeque<>();
        boolean flag=true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag) {
                System.out.print("Введите строку (или print для вывода строк, exit для выхода): ");
                String input = scanner.nextLine();

                if (input.equals("print")) {
                    while (!stack.isEmpty()) {
                        String str = stack.pop();
                        System.out.println(str);
                    }
                } else if (input.equals("exit")) {
                    flag=false;
                } else {
                    stack.push(input);
                }
            }
        }

        System.out.println("Завершение работы программы");
    }
}

