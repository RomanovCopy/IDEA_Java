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

    private static Set<Notebook> notebooks;
    private static Map<String, Comparator<Notebook>> sortingParameters;
    private static String[] operations;

    public static void main(String[] args) {

        sortingParameters = new HashMap<>();
        notebooks = createNotebooks();

        // Определение параметров и соответствующих компараторов для сортировки
        sortingParameters.put("brand", Comparator.comparing(Notebook::getBrand));
        sortingParameters.put("model", Comparator.comparing(Notebook::getModel));
        sortingParameters.put("price", Comparator.comparingInt(Notebook::getPrice));
        sortingParameters.put("ramSize", Comparator.comparingInt(Notebook::getRamSize));
        sortingParameters.put("hardDiskSize", Comparator.comparingInt(Notebook::getHardDiskSize));
        sortingParameters.put("gpuBrand", Comparator.comparing(Notebook::getGpuBrand));

        operations = new String[] {
                "Весь список",
                "Бренд",
                "Оперативная память",
                "Накопитель",
                "Видеокарта",
                "Цена",
        };
        sale();
    }

    public static boolean sale() {
        System.out.println("Доступные операции :");
        int count = 1;
        for (var name : operations) {
            System.out.printf("%d\t - %s\t\n", count, name);
            count++;
        }
        int operation = request("Введите номер операции :");
        var list = new ArrayList<>(notebooks);
        switch (operation) {
            case 1: {
                sortByParameter(list, Comparator.comparing(Notebook::getBrand));
                allList();
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
                var temp = setToMap(set);
                temp.forEach((key, value)->System.out.println(key+" "+value));
                selectRAM();
                break;
            }
            case 4: {
                System.out.println("Доступные объемы накопителя : ");
                var set = new HashSet<Integer>();
                notebooks.forEach(note -> set.add(note.getHardDiskSize()));
                var temp = setToMap(set);
                temp.forEach((key, value)->System.out.println(key+" "+value));
                selectHDD();
                break;
            }
            case 5: {
                System.out.println("Доступные бренды видеокарт : ");
                var set = new HashSet<String>();
                notebooks.forEach(note -> set.add(note.getGpuBrand()));
                var temp = setToMap(set);
                temp.forEach((key, value)->System.out.println(key+" "+value));
                selectGPU();
                break;
            }
            case 6: {
                System.out.println("Стоимость : ");
                var set = new HashSet<Integer>();
                notebooks.forEach(note -> set.add(note.getPrice()));
                var temp = setToMap(set);
                temp.forEach((key, value)->System.out.println(key+" "+value));
                selectPrice();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    private static void allList() {
        for (Notebook note : notebooks) {
            System.out.printf("%s\t  %s\t  %s\t  %d\t  %d\t  %d\t \n",
                    note.getBrand(), note.getModel(), note.getGpuBrand(), note.getHardDiskSize(),
                    note.getRamSize(), note.getPrice());
        }
    }

    /**
     * выбор модели исходя из бренда
     * @param set множество имен брендов
     * @return результат выбора True - удачно, False - отмена
     */
    private static boolean selectBrand(HashSet<String>set) {
        var temp = setToMap(set);
        temp.forEach((key,value)->System.out.println(key+" "+value));
        int brandKey = request("Введите номер бренда из представленных : ");
        //получаем множество моделей выбранного бренда
        Predicate<Notebook> predicate = note -> note.getBrand().equals(temp.get(brandKey));
        var setBrand = filter(notebooks, predicate);
        var models=new HashSet<String>();
        setBrand.forEach(item->models.add(item.getModel()));
        var listModels = setToMap(models);
        listModels.forEach((key,value)->System.out.println(key+" "+value));
        return true;
    }

    private static boolean selectRAM() {
        int ram = request("Введите размер ОЗУ из представленных :");
        return true;
    }

    private static boolean selectHDD() {
        int hdd = request("Введите размер накопителя из представленных :");

        return true;
    }

    private static boolean selectGPU() {
        int gpu = request("Введите номер видеокарты из представленных : ");
        return true;
    }

    private static boolean selectPrice() {
        int price = request("Введите стоимость из представленных :");
        return true;
    }

    /**
     * запрос к пользователю
     * 
     * @param text текст запроса
     * @return строка ответа
     */
    private static Integer request(String text) {
        int result = -1;
        System.out.print(text);
        try (Scanner scanner = new Scanner(System.in)) {
            result=Integer.parseInt(scanner.nextLine());
//            boolean flag=true;
//            while (flag) {
//                if (scanner.hasNextInt()) {
//                    result = scanner.nextInt();
//                    flag=false;
//                }
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
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


    public static Notebook selectNotebook(String brand, String model) {
        for (Notebook notebook : notebooks) {
            if (notebook.getModel().equals(model) && notebook.getBrand().equals(brand)) {
                return notebook;
            }
        }
        return null;
    }

    public static void sortByParameter(List<Notebook> notebooks, Comparator<Notebook> comparator) {
        if (comparator != null) {
            notebooks.sort(comparator);
        } else {
            System.out.println("Invalid parameter for sorting");
        }
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
    public static Set<Notebook> createNotebooks() {

        notebooks = new HashSet<>();

        // Создание и добавление ноутбуков в список
        notebooks.add(new Notebook("Brand1", "Model1", 1000, 8, 256, "GPU1"));
        notebooks.add(new Notebook("Brand2", "Model2", 1500, 16, 512, "GPU2"));
        notebooks.add(new Notebook("Brand3", "Model3", 1200, 8, 512, "GPU3"));
        notebooks.add(new Notebook("Brand4", "Model4", 3000, 32, 1024, "GPU1"));
        notebooks.add(new Notebook("Brand5", "Model5", 1500, 16, 512, "GPU2"));
        notebooks.add(new Notebook("Brand6", "Model6", 1200, 8, 512, "GPU3"));

        return notebooks;
    }

}
