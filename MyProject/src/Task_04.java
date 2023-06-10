/*К калькулятору из предыдущего ДЗ добавить логирование. */

import java.io.FileWriter;
import java.util.Scanner;

public class Task_04 {

    Scanner scanner;
    char[] operations;
    boolean exit;

    public Task_04() {
        scanner = new Scanner(System.in);
        operations = new char[] { '+', '-', '*', '/' };
        exit = false;

        try (FileWriter fw = new FileWriter("MyProject\\myCalcLog.txt", true)) {
            while (!exit) {
                System.out.print("Введите первое число :");
                double val1 = getValue();
                System.out.print("Введите оператор ( +, -, *, / ) :");
                char operator = getOperator();
                System.out.print("Введите второе число : ");
                double val2 = getValue();
                Double result=execute(val1, val2, operator);
                System.out.printf("%f %c %f = %f\n", val1, operator, val2, result);
                String log= Double.toString(val1)+ operator+Double.toString(val2)+"="+Double.toString(result)+"\n";
                fw.write(log);
                System.out.print("Продолжить? (1 - да, 0 - нет)");
                exit = getValue() == 0;
            }
        } catch (Exception e) {
            System.out.print("Ошибка: " + e.getMessage());
        }
    }

    private double getValue() {
        if (scanner.hasNextDouble())
            return scanner.nextDouble();
        else
            return 0;
    }

    private char getOperator() {
        return scanner.next().charAt(0);
    }

    private double execute(double val1, double val2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = val1 + val2;
                break;
            case '-':
                result = val1 - val2;
                break;
            case '*':
                result = val1 * val2;
                break;
            case '/':
                result = val2 != 0 ? val1 / val2 : 0;
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + operator);
        }
        return result;
    }

}
