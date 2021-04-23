package DataStructuresImp;

public class Queue<E> {
    private java.util.LinkedList<E> list = new java.util.LinkedList<>();

    public void enqueue(E e){
        list.addLast(e);
    }

    public E dequeue(){
        if (list.isEmpty()){
            return null;
        }

        return list.removeFirst();
    }

    public int getSize(){
        return list.size();
    }

    public boolean inside(E value){
        return list.contains(value);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public E first(){
        if (list.isEmpty())
            return null;
            E tail = list.get(0);
            return tail;
    }
    public E last(){
        if (list.isEmpty())
            return null;
        int n = list.size();
        E head = list.get(n-1);
        return head;
    }


    @Override
    public String toString(){
        return "Queue: " + list.toString();
    }

    public static void main(String[]args){
        Queue<Integer> list = new Queue<>();

        list.enqueue(5);
        list.enqueue(6);
        list.enqueue(25);
        list.enqueue(45);

        System.out.println(list);
        System.out.println("Size of list : "+ list.getSize());
        list.dequeue();
        list.dequeue();

        System.out.println("New size of list is" + list.getSize());
        System.out.println(list);
    }
}
