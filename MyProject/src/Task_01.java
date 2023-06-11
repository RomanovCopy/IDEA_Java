/*Пусть дан произвольный список целых чисел.

1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение */

import java.util.ArrayList;
import java.util.Random;

public class Task_01 {

    public Task_01() {
        // исходный список
        var list = create(20);

        System.out.println("Исходный список: " + list);
        System.out.println("Список после удаления четных чисел: " + removingEvenNumbers(list));
        System.out.println("Минимальное значение: " + min(list));
        System.out.println("Максимальное значение: " + max(list));
        System.out.println("Среднее значение: " + average(list));
    }

    /**
     * минимальное значение
     * 
     * @param arrayList
     * @return
     */
    private int min(ArrayList<Integer> arrayList) {
        int min = arrayList.get(0);
        for (int el : arrayList) {
            min = el < min ? el : min;
        }
        return min;
    }

    /**
     * максимальное значение
     * 
     * @param arrayList
     * @return
     */
    private int max(ArrayList<Integer> arrayList) {
        int max = arrayList.get(0);
        for (int el : arrayList) {
            max = el > max ? el : max;
        }
        return max;
    }

    /**
     * среднее арифметическое
     * 
     * @param arrayList
     * @return
     */
    private double average(ArrayList<Integer> arrayList) {
        int length = arrayList.size();
        int summ = 0;
        for (int el : arrayList) {
            summ += el;
        }
        return length != 0 ? summ / length : 0;
    }

    /**
     * удаление четных чисел
     * 
     * @param arrayList
     * @return
     */
    private ArrayList<Integer> removingEvenNumbers(ArrayList<Integer> arrayList) {
        // для предотвращения изменения исходного списка
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i : arrayList) {
            if (i % 2 != 0) {
                newList.add(i);
            }
        }
        return newList;
    }

    /**
     * создание списка
     * 
     * @param number количество элементов
     * @return список
     */
    private ArrayList<Integer> create(int number) {
        var list = new ArrayList<Integer>();
        var rand = new Random();
        for (int i = 0; i < number; i++) {
            list.add(rand.nextInt(100));
        }
        return list;
    }

}
