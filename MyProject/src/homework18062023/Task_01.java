package homework18062023;

import java.util.ArrayList;
import java.util.HashMap;

/*Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут 
повторяющиеся имена с разными телефонами, их необходимо считать, 
как одного человека с разными телефонами. 
Вывод должен быть отсортирован по убыванию числа телефонов. */


public class Task_01 {

    private HashMap<String, ArrayList<String>> contactList;

    public Task_01() {
        /*для примера создаем и заполняем коллекцию контактов */
        contactList=new HashMap<>();
        addContact("Николай","12345267" );
        addContact("Валерий","62527380" );
        addContact("Юрий","19383712" );
        addContact("Николай","9383746" );
        addContact("Юрий","12303627" );
        addContact("Николай","831320" );
        addContact("Наталья","7560123" );
        addContact("Наталья","7560123" );
        addContact("Вероника","13246354" );
        /*сортируем и выводим в консоль */
        printContacts(contactList);
    }

    /**
     * добавление контакта
     * @param name имя контакта
     * @param number номер телефона
     */
    public void addContact(String name, String number){
        //проверка на наличие контакта в списке контактов
        if(contactList.containsKey(name)){
            /*проверка на отсутствие номера среди номеров контакта 
             * если номера нет, то добавляем иначе, пропускаем*/
            if(!contactList.get(name).contains(number))
                contactList.get(name).add(number);
        }
        else{
            /*добавление нового контакта */
            var list=new ArrayList<String>();
            list.add(number);
            contactList.put(name, list);
        }
    }

    /**
     * Сортировка и вывод в консоль
     * @param contacts
     */
    public void printContacts(HashMap<String, ArrayList<String>> contacts){
        /*В методе sort() получаем отсортированную коллекцию ключей
         * и затем выводим контакты в порядке следования ключей*/
        for(String key:sort(contacts)){
            System.out.printf("Имя : %S \t Телефон : %S \t\n",key,contacts.get(key));
        }

    }


    /**
     * сортировка ключей в зависимости от длины списка в их значении
     * (сортировка пузырьком)
     * @param hashMap коллекция, ключи которой необходимо отсортировать
     * @return отсортированная коллекция ключей
     */
    private ArrayList<String> sort(HashMap<String, ArrayList<String>>hashMap) {
        ArrayList<String> keysList = new ArrayList<>(hashMap.keySet());
        int n = keysList.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                int count1=hashMap.get(keysList.get(j)).size();
                int count2=hashMap.get(keysList.get(j+1)).size();
                if (count1 < count2) {
                    var temp = keysList.get(j);
                    keysList.set(j, keysList.get(j+1));
                    keysList.set(j+1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return keysList;
    }

    
}
