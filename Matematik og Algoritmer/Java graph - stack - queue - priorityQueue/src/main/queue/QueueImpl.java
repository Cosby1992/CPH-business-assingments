package main.queue;

public class QueueImpl<T> implements Queue<T> {

    private T[] queue;
    private int newItemPos = 0;

    public QueueImpl(int size) {
        queue = (T[]) new Object[size]; 
    }

    @Override
    public void enqueue(T node) {
        queue[newItemPos++] = node;
    }

    /**
     * [5,3,7,89,null,null,null,null]
     *         ↑
     *      newItemPos-1
     * 
     * Ater dequeue
     * [3,7,89,89,null,null,null,null]
     *      ↑
     *  newItemPos-1
     */
    @Override
    public T dequeue() {
        T returnItem = queue[0];
        int lastItem = newItemPos--;
        for (int i = 1; i < lastItem; i++) {
            queue[i-1] = queue[i];
        }
        
        return returnItem;
    }

    @Override
    public boolean isEmpty() {
        return newItemPos == 0;
    }

    @Override
    public String toString() {
        
        StringBuilder builder = new StringBuilder();
        builder.append("Queue [");
        for (T t : queue) {
            builder.append(t);
            builder.append(" ");
        }
        builder.append("]\n");
        
        return builder.toString();
    }
    
}
