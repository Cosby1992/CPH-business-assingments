

class Main {

    public static void main(String[] args) {
        
        // printArrayStackTest(20);
        // printLinkedStackTest(20);

        //printQueueListTest(20);

    }

    static void printArrayStackTest(int size) {

        System.out.println("Running ArrayStack Tests... \n");
    
        // Creating an Array Stack of Integer type
        Stack<Integer> stack = new ArrayStack<>(size);
        
        System.out.print("Inserting elements: [");
        
        // Filling stack with iteration numbers
        for (int i = 0; i < size; i++) {
            stack.push(i);
            if(i != size-1) System.out.print(i + ", ");
            else System.out.print(i);
        }
    
        System.out.print("]\n\n");
        
        System.out.println("Peeking and Popping: ");
        
        // Peeking and popping till Stack is empty
        while(!stack.isEmpty()){
            System.out.print("Peek: " + stack.peek() + " ");
            System.out.println("Pop: " + stack.pop());
        }
    }

    static void printLinkedStackTest(int iterations) {
        System.out.println("Running LinkedStack Tests... \n");

        // Creating a Linked Stack of Integer type
        LinkedStack<Integer> stack = new LinkedStack<>();

        System.out.print("Inserting elements: [");
        
        // Filling stack with iteration numbers
        for (int i = 0; i < iterations; i++) {
            stack.push(i);
            if(i != iterations-1) System.out.print(i + ", ");
            else System.out.print(i);
        }
    
        System.out.print("]\n\n");
        
        System.out.println("Peeking and Popping: ");
        
        // Peeking and popping till Stack is empty
        while(!stack.isEmpty()){
            System.out.print("Peek: " + stack.peek() + " ");
            System.out.println("Pop: " + stack.pop());
        }
    }

    static void printQueueListTest(int iterations) {
        System.out.println("Running QueueList Tests... \n");
        Queue<Integer> queue = new QueueList<>();

        System.out.print("Inserting elements: [");
        for (int i = 0; i < iterations; i++) {
            queue.enqueue(i*2);
            if(i != iterations-1) System.out.print(i*2 + ", ");
            else System.out.print(i*2);
        }
        System.out.print("]\n\n");

        System.out.println("Peeking and Dequeue: ");
        while(!queue.isEmpty()){
            System.out.print("Peek: " + queue.peek() + " ");
            System.out.println("Dequeue: " + queue.dequeue());
        }

    }
}

