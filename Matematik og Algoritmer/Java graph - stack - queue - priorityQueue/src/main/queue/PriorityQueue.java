package main.queue;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

    private T[] pQueue;
    private int pointer = 0;

    // Constructor
    public PriorityQueue(int size) {
        pQueue = (T[]) new Comparable[size];
    }
    
    @Override
    public void enqueue(T node) {
        pQueue[pointer++] = node;
    }

    @Override
    public T dequeue() {
        
        T firstPriority = pQueue[0];
        int index = 0;

        for (int i = 1; i < pointer; i++) {
            if(pQueue[i] != null && firstPriority.compareTo(pQueue[i]) > 0){
                firstPriority = pQueue[i];
                index = i;
            }
        }

        for (int i = index; i < pointer; i++) {
            if((i+1) < pQueue.length) pQueue[i] = pQueue[i+1];
        }

        pointer--;
        
        return firstPriority;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    @Override
    public String toString() {
        
        StringBuilder builder = new StringBuilder();
        builder.append("Queue [");
        for (T t : pQueue) {
            builder.append(t);
            builder.append(" ");
        }
        builder.append("]\n");
        
        return builder.toString();
    }
    
}
