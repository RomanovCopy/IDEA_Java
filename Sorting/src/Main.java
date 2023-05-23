import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 3};
        //bubbleSort(arr);//сортировка пузырьком
        quickSort(arr, 0, arr.length-1);//быстрая сортировка
        System.out.println(Arrays.toString(arr));
    }

    //СОРТИРОВКА ПУЗЫРЬКОМ
    //В этом примере мы используем два вложенных цикла для перебора элементов
    // массива и сравнения их значений. Если значение текущего элемента больше
    // значения следующего элемента, то мы меняем их местами. Таким образом,
    // на каждой итерации внешнего цикла мы "выталкиваем" наибольший элемент
    // в конец массива. После прохода по всем элементам массива внешним циклом,
    // мы получаем отсортированный массив.
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //БЫСТРАЯ СОРТИРОВКА
    //В этом примере мы используем рекурсивный подход для разделения массива на
    // подмассивы и их сортировки. Мы выбираем опорный элемент (pivot) и перемещаем
    // все элементы меньше его влево, а все элементы больше его вправо.
    // Затем мы рекурсивно вызываем quickSort() для левой и правой частей
    // массива до тех пор, пока массив не будет полностью отсортирован.
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}