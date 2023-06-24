package homework24062023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
    }


    public boolean sale() {
        int operation = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Выберите операцию :");
            int count = 1;
            for (var name : operations) {
                System.out.printf("%d\t - %s\t\n", count, name);
                count++;
            }
            operation = scanner.nextInt();
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        var list=new ArrayList<>(notebooks);
        switch (operation) {
            case 1: {
                sortByParameter(list, sortingParameters, "brand");
                allList();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6:{
                break;
            }
            default :{
                return false;
            }
        }

        return true;
    }

    private static void allList(){
        for(Notebook note:notebooks){
            System.out.printf("%s\t  %s\t  %s\t  %d\t  %d\t  %d\t ", 
            note.getBrand(), note.getModel(), note.getGpuBrand(), note.getHardDiskSize(), 
            note.getRamSize(), note.getPrice());
        }
    }

    public static Notebook selectNotebook(String brand, String model) {
        for (Notebook notebook : notebooks) {
            if (notebook.getModel().equals(model) && notebook.getBrand().equals(brand)) {
                return notebook;
            }
        }
        return null;
    }

    public static void sortByParameter(List<Notebook> notebooks,
            Map<String, Comparator<Notebook>> sortingParameters,
            String parameter) {
        Comparator<Notebook> comparator = sortingParameters.get(parameter);
        if (comparator != null) {
            notebooks.sort(comparator);
        } else {
            System.out.println("Invalid parameter for sorting");
        }
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
        notebooks.add(new Notebook("Brand4", "Model4", 3000, 32, 512, "GPU1"));
        notebooks.add(new Notebook("Brand5", "Model5", 1500, 16, 512, "GPU2"));
        notebooks.add(new Notebook("Brand6", "Model6", 1200, 8, 512, "GPU3"));

        return notebooks;
    }

}
