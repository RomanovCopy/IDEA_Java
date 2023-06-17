
/*Написать метод, который принимает массив элементов, помещает их в очередь и выводит на консоль содержимое очереди. */

import java.util.LinkedList;
import java.util.Queue;

public class _040 {

    public _040() {
        String[] elements = { "apple", "banana", "cherry", "date", "elderberry" };
        printQueueContents(elements);
    }

    public void printQueueContents(String[] elements) {

        Queue<String> queue = new LinkedList<>();

        // Добавление элементов в очередь
        for (String element : elements) {
            //queue.add(element);//выбрасывает ошибку
            queue.offer(element);//не выбрасывает ошибку
        }

        // Вывод содержимого очереди
        while (!queue.isEmpty()) {
            String element = queue.poll();
            System.out.println(element);
        }
    }
}

