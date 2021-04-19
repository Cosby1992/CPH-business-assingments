package main.queue;

public interface Queue<T> {
    
    /**
     * Method to insert a new element to the queue
     * @param node element to be inserted
     */
    void enqueue(T node);
    
    /**
     * Method that removes the last element from the queue
     * @return the element removed
     */
    T dequeue();

    /**
     * Method that checks weather the queue is empty
     * @return boolean (true if empty)
     */
    boolean isEmpty();

}
