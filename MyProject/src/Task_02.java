/*Заполнить список десятью случайными числами. 
Отсортировать список методом sort() и вывести его на экран. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Task_02 {


    public Task_02(){
        ArrayList<Integer> l=create(10);
        Collections.sort(l);

        System.out.println(Arrays.toString(l.toArray()));
    }


    private ArrayList<Integer> create(int number) {
        var list = new ArrayList<Integer>();
        var rand = new Random();
        for (int i = 0; i < number; i++) {
            list.add(rand.nextInt(100));
        }
        return list;
    }

}
