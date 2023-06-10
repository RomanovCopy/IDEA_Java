/*Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл */

import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

public class Task_02 {



    public Task_02() {
        var myArray = createArray(10);
        System.out.println(Arrays.toString(myArray));
        myArray=sorted(myArray);
        System.out.println(Arrays.toString(myArray));
    }

     /**
      * сортировка пузырьком с записью в лог при каждой перестановке
      * @param myarray сортируемый массив
      * @return отсортированный массив
      */
    private int[] sorted( int[]myarray){
        var array=myarray;
        int iteration=0;
        try (FileWriter fw = new FileWriter("MyProject\\myLog.txt")){
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    fw.write("Итерация " + (iteration+=1) + ": "+ Arrays.toString(array) +",\n");
                    }
                }               
            }
        }catch(Exception e){
            System.out.print( "Ошибка: " + e.getMessage());
        }
        return array;
    }




    /**
     * создание массива заданного размера с
     * рандомными значениями от 1 до 100
     * 
     * @param number размер массива
     * @return запрашиваемый массив
     */
    private int[] createArray(int number) {
        var array = new int[number];
        var random = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

}
