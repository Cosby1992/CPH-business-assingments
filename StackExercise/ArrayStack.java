public class ArrayStack<T> implements Stack<T> {

    // Array to contain items 
    // int for position in array
    private T[] array;
    private int next = 0; 

    /**
     * Constructor
     * @param size size of array
     */
    public ArrayStack(int size) {
        // Type casting from object array to Generic type array
        // Java does not support direct initializing of generic type array
        this.array = (T[]) (new Object[size]);
    }

    /**
     * Adds a new item to the array 
     * and moves "next" pointer to new posistion
     * @param item item to add to the array
     */
    @Override
    public void push(T item) {
        array[next++] = item;
    }


    /**
     * Removes last item from array by decrementing 
     * position pointer
     * @return removed item
     */
    @Override
    public T pop() {
        return array[--next];
    }

    /**
     * @return last item of the array
     */
    @Override
    public T peek() {
        return array[next - 1];
    }

    /**
     * Checks if the array is empty
     * @return boolean (true if empty)
     */
    @Override
    public boolean isEmpty() {
        return next == 0;
    }

}
