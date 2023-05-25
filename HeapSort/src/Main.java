
public class Main {
    public static void main(String[]args){
        //массив для теста
        int arr[]={12, 11, 13, 5, 6, 7, 18, 0, 13, 7, -5};
        int n=arr.length;
        //запускаем тест
        Main.Sort(arr);
        //вывод отсортированного массива
        System.out.println("Отсортированный массив: ");
        for (int i=0; i<n; ++i){
            System.out.println(arr[i]+" ");
        }
    }

    public static void sort(int arr[]){
        int n=arr.length;
        //построение пирамиды
        for(int i = n / 2 - 1; i >= 0; i--) {
            Hepify(arr, n, i);
        }
        //извлекаем элементы из пирамиды
        for (int i=n-1; i>=0; i--){
            //перемещаем текущий корень в конец
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            //просеивание корня пирамиды
            Hepify(arr, i,0);
        }
    }

    //просеивание поддерева с корнем i
    public static void hepify(int arr[], int n, int i){
        int largest = i;//инициализируем наибольший элемент как корень
        int l=2*i+1;//левый дочерний элемент
        int r=2*i+2;//правый дочерний элемент

        //если левый дочерний элемент больше корня
        if(l<n && arr[l]>arr[largest])
            largest=l;

        //если правый дочерний элемент больше, чем наибольший элемент
        //на данный момент
        if(r<n && arr[r]>arr[largest]){
            largest=r;
        }

        //если наибольший элемент не корень
        if(largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;

            //рекурсивно просеиваем поддерево
            Hepify(arr,n,largest);
        }
    }
}