
/*Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства.
Знаки вопроса - одинаковые цифры.
Предложить хотя бы одно решение или сообщить, что его нет.*/


import java.util.ArrayList;
import java.util.Scanner;


public class _010 {

    Character[]operations;
    String equation;//полное выражение
    String leftPart;//выражение до знака =
    String rightPart;//выражение после знака =
    int unknown;//колличество неизвестных разрядов(вместо цифры - '?')

    
    public _010(){
        operations=new Character []{'+', '-', '*', '/', '=' };
        System.out.print("Введи выражение: ");
        equation = getEquation();
        if(leftPart.length()>0 && rightPart.length()>0){
            var list = searchForOptions(leftPart, rightPart, unknown);
            if(list.size()>0){
                for(var eq:list){
                    System.out.println(eq);
                }
            }
            else{
                System.out.println("Вариантов удовлетворяющих выражению не найдено");
            }
        }
    }

    //получение и первичная обработка уравнения
    private String getEquation(){

        var scanner=new Scanner(System.in);
        var value=scanner.nextLine();
        scanner.close();
        var array=value.split("[=]");
        leftPart=array[0];
        rightPart=array[1];
        for(int i=0; i<value.length();i++) unknown+=value.charAt(i)=='?'?1:0;
        return value;
    }

    private ArrayList<String>searchForOptions(String left, String right, int number){
        var list=new ArrayList<String>();

        return list;
    }
}
