package DataStructuresImp;

public class PriorityQueue<E extends Comparable<E>> {
    private Heap<E> heap = new Heap<>();

    public void enqueue(E newObject) {
        heap.add(newObject);
    }

    public E dequeue() {
        return heap.remove();
    }

    public int getSize(){
        return heap.getSize();
    }

    public static void main(String[]args){
        PriorityQueue<Integer> list = new PriorityQueue<>();

    }

}
