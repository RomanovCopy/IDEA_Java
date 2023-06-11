/*Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. 
Вывести название каждой планеты и количество его повторений в списке.

Земля, Земля, Земля, Юпитер

Земля: 3
Юпитер: 1 */

import java.util.ArrayList;
import java.util.Random;

public class Task_01 {

    private ArrayList<String> list;

    private String[] system;

    public Task_01(){
        
        system=new String[]{"Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун", "Плутон"};
        list=create(10);
        print();

    }

    private void print(){

        for(var item: system){
            int count=0;
            for(var sub:list){
                if(sub==item){
                    count++;
                }
            }
            System.out.print(item+"-"+Integer.toString(count)+"\n");
        }
    }


    private ArrayList<String> create(int number){
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<number;i++){
            Random rand=new Random();
            int c=rand.nextInt(9);
            list.add(system[c]);
        }
        return list;
    }
}

