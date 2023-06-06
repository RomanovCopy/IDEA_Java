
//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

//В данном классе мы генерируем двусвязный список, выводим его в консоль, реверсируем,
//и снова выводим в консоль уже в реверсированном виде

public class Main {

    static private Node head;//начальный элемент списка

    public static void main(String[] args) {
        //генерируем список
        createList(15);
        System.out.println("Список до реверсирования :");
        //выводим список в начальном виде
        printList();
        //реверсируем список
        reverse();
        System.out.println("Список после реверсирования :");
        //выводим список после реверсирования
        printList();
    }

    //реверсирование списка
    public static void reverse() {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            current = current.getPrev();
        }
        if (temp != null) {
            head = temp.getPrev();
        }
    }

    //генерация списка из заданного количества элементов
    public static void createList(int size){
       Node newNode=null;
        Node current=null;
        for(int i=0 ; i<size; i++){
            newNode=new Node(i);
            if(head==null){
                head=newNode;
            }
            else {
                current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
                newNode.setPrev(current);
            }
        }
    }

    //вывод списка
    public static void printList(){
        Node current=head;
        while (current!=null){
            System.out.print(current.getValue()+" ");
            current=current.getNext();
        }
        System.out.println();
        }
    }
