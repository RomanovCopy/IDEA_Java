
import java.util.ArrayList;
import java.util.LinkedList;
/*1) Замерьте время, за которое в ArrayList добавятся 100000 элементов.

2) Замерьте время, за которое в LinkedList добавятся 100000 элементов. Сравните с предыдущим. */
public class _010 {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTime = System.nanoTime();

    public _010(){

        long endTime = System.nanoTime();
                // Добавление 100000 элементов в ArrayList
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long duration = (endTime - startTime) / 1000000; // Перевод в миллисекунды


        System.out.println("Время выполнения: " + duration + " мс");

        
        startTime = System.nanoTime();
        // Добавление 100000 элементов в LinkedList
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();

        

        long duration1 = (endTime - startTime) / 1000000; // Перевод в миллисекунды

        System.out.println("Время выполнения для LinkedList: " + duration1 + " мс");

    }


}
