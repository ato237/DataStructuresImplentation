package DataStructuresImp;

public class Stack<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    public void push(E e){
        list.add(e);
    }

    public E pop(){
        if (list.isEmpty()){
            return null;
        }
        E top = list.get(list.size() - 1);
        list.remove(list.size()- 1);
        return top;
    }

    public E peek(){
        if (list.isEmpty()){
            return null;
        }
        E top  = list.get(list.size()-1);
        return top;
    }

    public boolean inside(E value){
        return list.contains(value);
    }

    public int size(){
        return list.size();
    }


    public boolean isEmpty(){
        return list.isEmpty();
    }

    public String toString(){
        return "Stack: " + list.toString();
    }


    public static void main(String[] args){
        Stack<Integer> list = new Stack<>();

        list.push(5);
        list.push(7);
        list.push(4);
        list.push(9);

        for (int i = 0; i<list.size();i++)
        System.out.println(list);

        System.out.println("Is stack empty: " + list.isEmpty());


        System.out.println("Stack size " +list.size());
        list.pop();
        list.pop();
        System.out.println("is Stack empty: " + list.isEmpty());
        System.out.println(list.size());
        System.out.println("After pop" +list);


    }

}
