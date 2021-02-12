
public class QueueList<T> implements Queue<T> {

    private Node<T> top = null;
    private Node<T> bottom = null;

    private class Node<T> {

        Node<T> next;
        final T value;

        public Node(T value) {
            this.value = value;
        }

    }

    /**
     * Inserts a new item in the queue
     * @param item to add to queue
     */
    @Override
    public void enqueue(T item) {

        // Create a new Node
        Node<T> temp = new Node<T>(item);

        // If queue is empty, then new node is both top and bottom
        if (this.top == null) {
            this.bottom = this.top = temp;
            return;
        }

        // Add the new node at the end of queue and change top
        this.top.next = temp;
        this.top = temp;

    }

    /**
     * Removes "last" element from the queue (FIFO)
     * @return item from removed element
     */
    @Override
    public T dequeue() {
        // if queue is empty 
        if(bottom == null) return null; 

        // value from current bottom element
        final T value = bottom.value;
        
        // set bottom to "next in line in the queue"
        bottom = bottom.next;

        return value;

    }

    /**
     * @return the current "last" element in the queue
     */
    @Override
    public T peek() {
        return bottom.value;
    }

    /**
     * Checks if the queue is empty
     * @return boolean (true if empty)
     */
    @Override
    public boolean isEmpty() {
        return bottom == null;
    }

}
