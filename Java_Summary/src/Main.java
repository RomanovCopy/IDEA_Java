import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String a="Romanov", b="Sergey";

        if(a.equals(b)){ //сравнивание строк только так, остальное как в C#

        }

        float f=5.23144f;
        Scanner sc=new Scanner(System.in);
        int number= sc.nextInt();
        switch (number){
            case 1:
                System.out.print("Number 1");
                break;
            case 2:
                System.out.print("Number 2");
                break;
            default:
                System.out.print("No");
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(14);
        list.add(46);
        list.add(17);
        list.add(1,39);//вставка нового элемента в указанную позицию 1
                                    //произойдет сдвиг всех дальнейших элементов на одну позицию вниз
        System.out.print(list.size());//длина коллекции

        for(int i : list){


        }

        LinkedList<Integer>linkedList=new LinkedList<>();




    }
}