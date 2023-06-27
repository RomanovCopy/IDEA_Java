package homework24062023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Program {
    /**
     * множество товаров
     */
    private static HashSet<Notebook> notebooks;
    /**
     * доступные операции
     */
    private static String[] operations;
    /**
     * поток чтения с консоли
     */
    private static Scanner scanner;
    public static void main(String[] args) {
        //создание множества товаров
        notebooks = createNotebooks();
        //создание массива доступных операций
        operations = new String[] {
                "Весь список",
                "Бренд",
                "Оперативная память",
                "Накопитель",
                "Видеокарта",
                "Цена",
        };
        //запускаем программу
        if(scanner==null){
            scanner=new Scanner(System.in);
            sale();
            scanner.close();
        }
    }

    /**
     * ребота продавца
     * @return
     */
    public static boolean sale() {
        System.out.println("Доступные операции :");
        int count = 1;
        for (var name : operations) {
            System.out.printf("%d\t - %s\t\n", count, name);
            count++;
        }
        int operation = request("Введите номер операции :");
        switch (operation) {
            case 1: {
                allList(notebooks);
                break;
            }
            case 2: {
                System.out.println("Доступные бренды : ");
                var set = new HashSet<String>();
                notebooks.forEach(note -> set.add(note.getBrand()));
                selectBrand(set);
                break;
            }
            case 3: {
                System.out.println("Доступные размеры RAM : ");
                var set = new HashSet<Integer>();
                notebooks.forEach(note -> set.add(note.getRamSize()));
                selectRAM(set);
                break;
            }
            case 4: {
                System.out.println("Доступные объемы накопителя : ");
                var set = new HashSet<Integer>();
                notebooks.forEach(note -> set.add(note.getHardDiskSize()));
                selectHDD(set);
                break;
            }
            case 5: {
                System.out.println("Доступные бренды видеокарт : ");
                var set = new HashSet<String>();
                notebooks.forEach(note -> set.add(note.getGpuBrand()));
                selectGPU(set);
                break;
            }
            case 6: {
                System.out.println("Стоимость : ");
                var set = new HashSet<Integer>();
                notebooks.forEach(note -> set.add(note.getPrice()));
                selectPrice(set);
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    /**
     * выбор модели исходя из множества моделей
     * @param set множество моделей
     */
    private static void allList(HashSet<Notebook>set) {
        int index=1;
        var list = new ArrayList<>(set);
        list.sort(Comparator.comparing(Notebook::getBrand));
        HashMap<Integer, Notebook>map=new HashMap<>();
        for(var item:list){
            map.put(index, item);
            index++;
        }
        map.forEach((key,value)->System.out.println(key+" "+value.toString()));
        index=request("Выберите номер модели : ");
        if( map.containsKey(index)){
            var selectNotebook=map.get(index);
            System.out.printf("Ваш выбор : %s", map.get(index).toString() );
            System.out.println("Спасибо за покупку!1");
        }
        else {
            System.out.println("Вы ничего не выбрали.");
        }
        System.out.println("Приходите еще!");
    }

    /**
     * выбор модели исходя из бренда
     * @param set множество имен брендов
     * @return результат выбора True - удачно, False - отмена
     */
    private static void selectBrand(HashSet<String>set) {
        var temp = setToMap(set);
        temp.forEach((key,value)->System.out.println(key+" "+value));
        int brandKey = request("Введите номер бренда из представленных : ");
        //получаем множество моделей выбранного бренда
        Predicate<Notebook> predicate = note -> note.getBrand().equals(temp.get(brandKey));
        var setBrand = filter(notebooks, predicate);
        allList(setBrand);
    }

    /**
     * выбор модели исходя из размера ОЗУ
     * @param set множество доступных размеров ОЗУ
     */
    private static void selectRAM(HashSet<Integer>set) {
        var temp = setToMap(set);
        temp.forEach((key,value)->System.out.println(key+" "+value));
        int ramKey = request("Введите номер ОЗУ из представленных :");
        //получаем множество моделей выбранного размера ОЗУ
        Predicate<Notebook> predicate = note -> note.getRamSize()== temp.get(ramKey);
        var setRam = filter(notebooks, predicate);
        allList(setRam);
    }

    /**
     * выбор на основании размера накопителя
     * @param set множество доступных размеров накопителей
     */
    private static void selectHDD(HashSet<Integer>set) {
        var temp = setToMap(set);
        temp.forEach((key,value)->System.out.println(key+" "+value));
        int hddKey = request("Введите размер накопителя из представленных :");
        //получаем множество моделей выбранного размера накопителя
        Predicate<Notebook> predicate = note -> note.getHardDiskSize()== temp.get(hddKey);
        var setHDD = filter(notebooks, predicate);
        allList(setHDD);
    }

    /**
     * выбор на основании модели видеокарты
     * @param set множество доступных моделей видеокарт
     */
    private static void selectGPU(HashSet<String>set) {
        var temp = setToMap(set);
        temp.forEach((key,value)->System.out.println(key+" "+value));
        int gpuKey = request("Введите номер видеокарты из представленных : ");
        //получаем множество моделей выбранного размера накопителя
        Predicate<Notebook> predicate = note -> note.getGpuBrand().equals(temp.get(gpuKey));
        var setGpu = filter(notebooks, predicate);
        allList(setGpu);
    }

    /**
     * выбор на основе цены
     * @param set множество доступных цен
     */
    private static void selectPrice(HashSet<Integer>set) {
        var temp = setToMap(set);
        temp.forEach((key,value)->System.out.println(key+" "+value));
        int priceKey = request("Введите стоимость из представленных :");
        //получаем множество моделей выбранного размера накопителя
        Predicate<Notebook> predicate = note -> note.getPrice()==temp.get(priceKey);
        var setPrice = filter(notebooks, predicate);
        allList(setPrice);
    }

    /**
     * запрос к пользователю
     * 
     * @param text текст запроса
     * @return строка ответа
     */
    private static Integer request(String text) {
        int result = -1;
        String temp="";
        System.out.print(text);
        if(scanner.hasNextInt()){
            result=scanner.nextInt();
        }
        return result;
    }

    /**
     * преобразование с сортировкой множества HashSet<T> в словарь
     * @param set исходное множество
     * @return результирующий словарь
     * @param <T>
     */
    private static <T> HashMap<Integer, T> setToMap(HashSet<T> set) {
        HashMap<Integer, T> hashMap = new HashMap<>();
        TreeSet<T> sortedSet = new TreeSet<>(set);
        int key = 1;
        for (T item : sortedSet) {
            hashMap.put(key, item);
            key++;
        }
        return hashMap;
    }

    /**
     * получение множества удовлетворяющих условию экземпляров
     * 
     * @param notebooks       исходное множество
     * @param filterPredicate предикат фильтрования
     * @return отфильтрованное множество
     */
    public static HashSet<Notebook> filter(Set<Notebook> notebooks, Predicate<Notebook> filterPredicate) {
        HashSet<Notebook> filteredObjects = new HashSet<>();
        for (Notebook note : notebooks) {
            if (filterPredicate.test(note)) {
                filteredObjects.add(note);
            }
        }
        return filteredObjects;
    }

    /**
     * создание множества товаров
     * 
     * @return
     */
    public static HashSet<Notebook> createNotebooks() {

        notebooks = new HashSet<>();

        // Создание и добавление ноутбуков в множество
        notebooks.add(new Notebook("Brand1", "Model1", 1000, 8, 256, "GPU1"));
        notebooks.add(new Notebook("Brand2", "Model2", 1500, 16, 512, "GPU2"));
        notebooks.add(new Notebook("Brand3", "Model3", 1200, 8, 512, "GPU3"));
        notebooks.add(new Notebook("Brand4", "Model4", 3000, 32, 1024, "GPU1"));
        notebooks.add(new Notebook("Brand5", "Model5", 1500, 16, 512, "GPU2"));
        notebooks.add(new Notebook("Brand6", "Model6", 1200, 8, 512, "GPU3"));

        return notebooks;
    }

}
