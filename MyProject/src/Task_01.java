/*Пусть дан произвольный список целых чисел.

1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Task_01 {
    
    public Task_01(){

        var list=create(20);

        System.out.println("Исходный список: "+ list);

            // Нахождение минимального значения
        int min = Collections.min(list);

        // Нахождение максимального значения
        int max = Collections.max(list);

        // Нахождение среднего значения
        double sum = 0;
        for (int num : list) {
            sum += num;
        }
        double avg = sum / list.size();

        // Удаление четных чисел
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        
        System.out.println("Список после удаления четных чисел: " + list);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + avg);
    }


    /**
     * создание списка
     * @param number количество элементов
     * @return список
     */
    private ArrayList<Integer>create(int number){
        var list =new ArrayList<Integer>();
        var rand=new Random();
        for(int i=0; i<number;i++){
            list.add(rand.nextInt(100));
        }
        return list;
    }



}
