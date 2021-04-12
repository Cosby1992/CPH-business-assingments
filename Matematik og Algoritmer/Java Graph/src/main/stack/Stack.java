package main.stack;

/**
 * Interface descripting a Stack with Generic datatype (LIFO - Last in first out)
 */
public interface Stack<T> {

    /**
     * Method to insert a new element to the stack
     * @param node element to be inserted
     */
    void push(T node);
    
    /**
     * Method that removes the last element from the stack
     * @return the element removed
     */
    T pop();

    /**
     * Method that checks weather the stack is empty
     * @return boolean (true if empty)
     */
    boolean isEmpty();

}
