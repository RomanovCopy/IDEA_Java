
/*Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства.
Знаки вопроса - одинаковые цифры.
Предложить хотя бы одно решение или сообщить, что его нет.*/


import java.util.Scanner;

public class _010 {

    Character[]operations;

    
    public _010(){
        operations=new Character []{'+', '-', '*', '/', '=' };
        String equation = getEquation();
        if(equation.length()>3){
            equation=equationNormalization(equation);
            String[]elements=gettingTheComponentsOfAnEquation(equation);

        }
    }

    //получение уравнения
    private String getEquation(){

        var value="";
        Scanner scanner=new Scanner(System.in);
        value=scanner.nextLine();
        scanner.close();
        return value;
    }

    private String equationNormalization(String equation){
        var value=equation;

        return value;
    }

    //разбиение уравнения на составные части
    private String[] gettingTheComponentsOfAnEquation(String equation){
        String[]array=equation.split("[+\\-\\/\\*\\=]");
        int count=0;
        array[count]=equation.charAt(count)=='-'?Character.toString('-')+array[count]:Character.toString('+')+array[count];
        count++;
        for(int i=1; i<equation.length();i++){
            char ch = equation.charAt(i);
            var notEnd=i<equation.length()-1;
            if(ch=='+'||ch=='-'){
                if(notEnd && !(equation.charAt(i+1)=='+'||equation.charAt(i+1)=='-')){
                    array[count]=Character.toString(ch)+array[count];
                    count++;
                }
            }
        }
        return array;
    }



}
