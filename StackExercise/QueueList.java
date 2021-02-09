import org.graalvm.compiler.nodes.NodeView.Default;

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

    @Override
    public T dequeue() {

        if(bottom == null) return null; 

        final T value = bottom.value;
        
        bottom = bottom.next;


        return value;

    }

    @Override
    public T peek() {
        return bottom.value;
    }

    @Override
    public boolean isEmpty() {
        return bottom == null;
    }

}
