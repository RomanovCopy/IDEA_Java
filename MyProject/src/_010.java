
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
    ArrayList<Integer>indexes;//позиции неизвестных элементов

    
    public _010(){
        operations=new Character []{'+', '-', '*', '/', '=' };
        indexes=new ArrayList<>();
        System.out.print("Введи выражение: ");
        equation = getEquation();
        if(leftPart.length()>0 && rightPart.length()>0 && indexes.size()>0){
            var list = searchForOptions(leftPart, rightPart);
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
        for(int i=0; i<value.length();i++){
            if(value.charAt(i)=='?'){
                indexes.add(i);
            }
        }
        return value;
    }

    private ArrayList<String>searchForOptions(String left, String right){
        var list=new ArrayList<String>();
        int digits=indexes.size();
        var array=equation.toCharArray();
        for(int index:indexes){
            array[index]='0';
        }
        for(int i=0;i<Math.pow(10, digits);i++){
            int value=(int)Math.pow(10, digits)+i;
            for(int index:indexes){
                int temp=value%10;
                var str=Integer.toString(temp);
                array[index]=str.toCharArray()[0];
                value/=10;
            }
            String temp=new String(array);
            if(validate(temp)){
                list.add(temp);
            }
        }
        return list;
    }

    private boolean validate(String option){
        boolean result=false;
        var array=option.split("[=]");
        var left=array[0];
        var right=array[1];
        var c=eval(left);
        return result;
    }

    private double eval(String expression ){
        double result=0;
        int count=0;
        var numbers = expression.split("[ \\+ \\- \\* \\/ ]");
        var operators=expression.split("[0-9]+\\s*");
        return result;
    }
}
