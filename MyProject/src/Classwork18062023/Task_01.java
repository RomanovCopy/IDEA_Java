package Classwork18062023;

import java.util.HashMap;
import java.util.Scanner;

/*Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации. */

public class Task_01 {

    private HashMap<String, String>list;
    
    public Task_01(){

        list=new HashMap<>(0, 0);

    }

    private void add(String number, String firstName){
        Scanner scaner=new Scanner(System.in);
        var num =scaner.nextLine();
        if(!list.containsKey(num)){
            var name = scaner.nextLine();
            list.put(num, name);
        }
        else{
            System.out.println("Такой номер паспорта уже существует");
        }
    }

}
