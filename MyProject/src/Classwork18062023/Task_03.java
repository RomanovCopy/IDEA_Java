package Classwork18062023;

import java.util.Scanner;
import java.util.Stack;

/*Написать программу, определяющую правильность расстановки скобок в выражении.
Пример 1: a+(d*3) - истина
Пример 2: [a+(1*3) - ложь */

public class Task_03 {

    public Task_03(){

        System.out.println("Введите выражение : ");
        try(Scanner scan=new Scanner(System.in)){
            var expression=scan.nextLine();
            System.out.println(isExpressionBalanced(expression));
        }
        

    }

    public static boolean isExpressionBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
}
