public class HTable<K,V> {

    private static final int initBasketSize =10;

    private class Entity{
        private K key;
        private V value;
    }

    private class Basket {

        private class BasketNode {
            private  Entity entity;
            private BasketNode next;
        }
        private BasketNode head;
        //public V find(K key){

        //}
    }
    private Basket basketArray[];
    private int calculateIndex(K key){
        return  Math.abs(key.hashCode())% basketArray.length;
    }

    public HTable(){
        this(initBasketSize);
    }

    public HTable(int initBasketSize){
        basketArray =(Basket[]) new Object[initBasketSize];
    }

    //public V find(K key){

    //}

}
