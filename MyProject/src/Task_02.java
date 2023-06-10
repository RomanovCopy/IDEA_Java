/*Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл */

import java.io.FileWriter;
import java.security.cert.TrustAnchor;
import java.util.Random;

public class Task_02 {

    private FileWriter fWriter;

    int[]myArray;

    public Task_02() {

        fWriter = new FileWriter("myLog.txt", true);
        myArray = createArray(50);

    }

    private void logging(int iteration, int[] array) {

        fWriter.write("After iteration " + (iteration + 1) + ": ");
        for (int k = 0; k < array.length; k++) {
            fWriter.write(array[k] + " ");
        }
    }

    /**
     * создание массива заданного размера с
     * рандомными значениями
     * 
     * @param number размер массива
     * @return запрашиваемый массив
     */
    private int[] createArray(int number) {
        var array = new int[number];
        var random = new Random(100);
        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

}
