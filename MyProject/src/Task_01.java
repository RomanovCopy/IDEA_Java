/*Даны два Deque, представляющие два целых числа. 
Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка.
Одно или два числа могут быть отрицательными. */

/*Для наглядности программа сама генерирует цифры от -9 до 9
 * и составляет из них списки заданной длины(по умолчанию: 3).
 * Затем эти списки преобразуются в числа с учетом обратного
 * расположения в списке и с полученными числами проводятся
 * арифметические операции после чего результат преобразованный
 * в связный список выводится в консоль
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Task_01 {

    public Task_01(String string) {

        var deque1 = generateRandomDeque(3);
        System.out.println("Первый Deque : ");
        printLinkedList(deque1);
        var num1=dequeToNumber(deque1);
        System.out.println(num1);
        var deque2 = generateRandomDeque(3);
        System.out.println("Второй Deque : ");
        printLinkedList(deque2);
        var num2=dequeToNumber(deque2);
        System.out.println(num2);
        System.out.printf("Умножение : %S * %S = %S \n", num1, num2, numberToLinkedList(num1*num2));
        System.out.printf("Сложение : %S + %S = %S \n", num1, num2, numberToLinkedList(num1+num2));
    }


    /**
     * преобразование Deque в число
     * @param deque список
     * @return число
     */
    private int dequeToNumber(Deque<Integer> deque) {
        //подсчет отрицательных цифр
        int negativeCount = 0;
        for (int digit : deque) {
            if (digit < 0) {
                negativeCount++;
            }
        }
        int number = 0;
        int multiplier = 1;
        /*выбираем цифры и 
         * составляем из них число*/
        while (!deque.isEmpty()) {
            int digit = deque.pollFirst();
            number += Math.abs(digit) * multiplier;
            multiplier *= 10;
        }
        /*на основе количества отрицательных
        *цифр определяем знак числа*/
        if (negativeCount % 2 != 0) {
            number *= -1;
        }

        return number;
    }


    /**
     * Преобразование числа в связный список
     * @param number число
     * @return связный список
     */
    private LinkedList<Integer> numberToLinkedList(int number) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        /*если число равно 0 */
        if (number == 0) {
            linkedList.add(0);
            return linkedList;
        }
        boolean isNegative = number<0;
        number = Math.abs(number);

        while (number > 0) {
            int digit = number % 10;
            linkedList.addFirst(digit);
            number /= 10;
        }
        /*Если входное число отрицательное, умножаем
         * нулевой элемент на -1*/
        if (isNegative) {
            linkedList.set(0, linkedList.get(0) * -1);
        }

        return linkedList;
    }

    /**
     * генерирует Deque<Integer> заполненный случайной
     * последовательностью цифр в интервале от -9 до 9 включительно
     *  заданного размера
     * @param numDigits разрядность
     * @return Deque<Integer>
     */
    private Deque<Integer> generateRandomDeque(int numDigits) {
        Deque<Integer> deque = new ArrayDeque<>();
        Random random = new Random();

        for (int i = 0; i < numDigits; i++) {
            int digit = random.nextInt(20) - 10; // Генерация чисел от -9 до 9 включительно
            deque.offerLast(digit);
        }

        return deque;
    }

    /**
     * вывод консоль
     * 
     * @param deque
     */
    public static void printLinkedList(Deque<Integer> deque) {
        for (int digit : deque) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }
}
