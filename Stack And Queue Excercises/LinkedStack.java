public class LinkedStack<T> implements Stack<T> {

    // Current node
    private Node<T> top = null;

    // no-arg constructor
    public LinkedStack() {
    }

    /**
     * Inner class holding a reference node 
     * and a value
     */
    private class Node<T> {

        private final Node<T> next;
        private final T value;
    
        Node(Node<T> next, T value){
            this.next = next;
            this.value = value;
        }
    }


    /**
     * Adds a new Node to the top of the stack
     * with a reference to the previous top Node
     */
    @Override
    public void push(T item) {
        top = new Node(top, item);
    }

    /**
     * Getting value from current top Node
     * Defines new top of stack by old tops reference
     * 
     * @return value from current top of stack
     */
    @Override 
    public T pop() {

        T value = top.value;
        top = top.next;

        return value;
    }

    /**
     * @return value of the current top of the stack
     */
    @Override
    public T peek() {
        return top.value;
    }

    /**
     * Checks if the stack is empty
     * @return boolean (true if empty)
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
}
