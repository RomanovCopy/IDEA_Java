


import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer>myList=null;
        myList=createList(10);
        printList(myList);
        reverse(myList.getFirst());
    }

    public static void reverse(Node head) {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public static LinkedList<Integer> createList(int size){
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<size;i++){
            add(list,i);
        }
        return list;
    }

    public static void add(LinkedList<Integer> list, int value) {
        Node head=list.get(0);
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }
    }

    public static void printList(LinkedList<Integer> list){
        for(int val : list)
           System.out.print(node);
        }
    }
}