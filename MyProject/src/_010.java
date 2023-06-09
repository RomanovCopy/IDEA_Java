
/*Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства.
Знаки вопроса - одинаковые цифры.
Предложить хотя бы одно решение или сообщить, что его нет.*/

import java.util.ArrayList;
import java.util.Scanner;

public class _010 {

    Character[] operations;
    Character[] numbers;
    String equation;// полное выражение
    String leftPart;// выражение до знака =
    String rightPart;// выражение после знака =
    ArrayList<Integer> indexes;// позиции неизвестных элементов

    public _010() {
        operations = new Character[] { '+', '-', '*', '/', '=', ')', '(' };
        numbers = new Character[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        indexes = new ArrayList<>();
        System.out.print("Введи выражение: ");
        equation = getEquation();
        if (leftPart.length() > 0 && rightPart.length() > 0 && indexes.size() > 0) {
            var list = searchForOptions(leftPart, rightPart);
            if (list.size() > 0) {
                for (var eq : list) {
                    System.out.println(eq);
                }
            } else {
                System.out.println("Вариантов удовлетворяющих выражению не найдено");
            }
        }
    }

    /**
     * ввод и первичная обработка выражения
     */
    private String getEquation() {

        var scanner = new Scanner(System.in);
        var value = scanner.nextLine();
        scanner.close();
        value=value.replace(" ", "");
        var array = value.split("[=]");
        leftPart = array[0];// левая часть выражения
        rightPart = array[1];// правая часть выражения
        // поиск индексов неизвестных значений
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '?') {
                indexes.add(i);
            }
        }
        return value;
    }

    /**
     * перебор и расчет значений неизвестных
     * 
     * @param left  левая часть выражения
     * @param right правая часть выражения
     * @return массив удовлетворяющих условию выражений
     */
    private ArrayList<String> searchForOptions(String left, String right) {
        var list = new ArrayList<String>();
        int digits = indexes.size();
        var array = equation.toCharArray();
        // установка начального значения(0) для неизвестных элементов
        for (int index : indexes) {
            array[index] = '0';
        }
        // перебор и валидация значений для неизвестных элементов
        for (int i = 0; i < Math.pow(10, digits); i++) {
            int value = (int) Math.pow(10, digits) + i;
            for (int index : indexes) {
                int temp = value % 10;
                var str = Integer.toString(temp);
                array[index] = str.toCharArray()[0];
                value /= 10;
            }
            // валидация выражения с
            // установленными значениями
            String temp = new String(array);
            if (validate(temp)) {
                list.add(temp);
            }
        }
        return list;
    }

    /**
     * проверка истинности выражения
     * 
     * @param option выражение
     * @return результат проверки True или False
     */
    private boolean validate(String option) {
        boolean result = false;
        var array = option.split("[=]");
        var left = array[0];
        var right = array[1];
        // вычисление левой части выражения
        var c = eval(left);
        // равенство левой и правой частей
        result = c == Integer.parseInt(right);
        if(result){
            result=Integer.parseInt(right)==eval(left);
        }
        return result;
    }

    /**
     * расчет строки
     * 
     * @param expression строка
     * @return результат
     */
    private int eval(String expression) {
        int result = 0;
        // обработка всех скобок в выражении
        int index = expression.indexOf(')', 1);
        while (index >= 0) {
            // определяем индекс ближайшей открывающей скобки
            char simbol = ')';
            int c = index;
            while (simbol != '(') {
                c--;
                simbol = expression.charAt(c);
            }
            // получаем подстроку из скобок
            var sub = expression.substring(c + 1, index);
            result = calculation(sub);
            // вычисляем значение подстроки
            var res = Integer.toString(result);
            // заменяем подстроку на результат выполнения операции
            expression = expression.replace("(" + sub + ")", res);
            index = expression.indexOf(')', 1);
        }
        result = calculation(expression);
        return result;
    }

    /**
     * вычисление строки с множеством операций,
     * но без скобок
     * 
     * @param line вычисляемая строка(String)
     * @return результат вычисления(double)
     */
    private int calculation(String line) {
        // индексы операций в строке
        var a = line.indexOf('*');
        var b = line.indexOf('/');
        var d = line.indexOf('+');
        var e = line.indexOf('-');
        if (a < 0 && b < 0 && d < 0 && e < 0) {
            // если нет операций, выводим результат
            return Integer.parseInt(line);
        }
        // выбор очередной операции
        int index = 0;
        char operation = '=';
        if (a > 0 || b > 0) {
            if (a > 0 && b > 0) {
                if (a < b) {
                    operation = '*';
                    index = a;
                } else {
                    operation = '/';
                    index = b;
                }
            } else if (a > 0 && b < 0) {
                operation = '*';
                index = a;
            } else {
                operation = '/';
                index = b;
            }
        } else if (d > 0 || e > 0) {
            if (d > 0 && e > 0) {
                if (d < e) {
                    operation = '+';
                    index = d;
                } else {
                    operation = '-';
                    index = e;
                }
            } else if (d > 0 && e < 0) {
                operation = '+';
                index = d;
            } else {
                operation = '-';
                index = e;
            }
        }
        // выполнение выбранной операции и переход к следующей
        int left = searchNumberLeft(line, index);// левое от знака значение
        int right = searchNumberRight(line, index);// правое от знака значение
        int result = simpleCalculation(left, right, operation);// выполнение операции
        int leftLength = Integer.toString(left).length();// длина левого значения
        int rightLength = Integer.toString(right).length();// длина правого значения
        int leftIndex = index - leftLength;// индекс начала левого значения
        int rightIndex = index + rightLength + 1;// индекс окончания правого значения
        // замена выражения на результат его выполнения
        String newLine = line.replace(line.substring(leftIndex, rightIndex), Integer.toString(result));
        // полученную новую строку отправляем на дальнейшую обработку
        return calculation(newLine);
    }

    /**
     * расчет простой операции
     * 
     * @param val1      первое значение
     * @param val2      второе значение
     * @param operation символ операции( + - * /)
     * @return результат
     */
    private int simpleCalculation(int val1, int val2, char operation) {
        int result = 0;
        switch (operation) {
            case '+': {
                result = val1 + val2;
                break;
            }
            case '-': {
                result = val1 - val2;
                break;
            }
            case '*': {
                result = val1 * val2;
                break;
            }
            case '/': {
                result = val1/val2;
                break;
            }
            default: {
            }
        }

        return result;
    }

    /**
     * поиск числа слева от заданной позиции в строке
     * 
     * @param line     строка
     * @param position позиция в строке
     * @return найденное число
     */
    private int searchNumberLeft(String line, int position) {
        int result = 0;
        String sub = "";
        for (int i = position - 1; i >= 0; i--) {
            var ch = line.charAt(i);
            var end = ch == '+' || ch == '-' || ch == '*' || ch == '/';
            if (!end) {
                sub = ch + sub;
            } else {
                result = Integer.parseInt(sub);
                return result;
            }
        }
        if (sub.length() > 0) {
            result = Integer.parseInt(sub);
        }
        return result;
    }

    /**
     * поиск числа справа от заданной позиции в строке
     * 
     * @param line     строка
     * @param position позиция в строке
     * @return найденное число
     */
    private int searchNumberRight(String line, int position) {
        int result = 0;
        String sub = "";
        for (int i = position + 1; i < line.length(); i++) {
            var ch = line.charAt(i);
            var end = ch == '+' || ch == '-' || ch == '*' || ch == '/';
            if (!end) {
                sub += ch;
            } else {
                result = Integer.parseInt(sub);
                return result;
            }
        }
        if (sub.length() > 0) {
            result = Integer.parseInt(sub);
        }
        return result;
    }


}
