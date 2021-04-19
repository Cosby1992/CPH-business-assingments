package main.queue;

import java.util.Comparator;

public class Test {
    
    public static void main(String[] args) {

        //testQueue();
        testPriorityQueue();

    }

    private static void testQueue() {
        Queue<String> queue = new QueueImpl<>(10);
        
        for (int i = 0; i < 10; i++) {
            queue.enqueue(String.valueOf(i));
        }

        System.out.println(queue);

        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }

    private static void testPriorityQueue() {
        Queue<String> queue = new PriorityQueue<>(10);

        for (int i = 0; i < 5; i++) {
            queue.enqueue(String.valueOf(i));
        }

        System.out.println(queue);

        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            queue.enqueue(String.valueOf(i));
        }

        System.out.println(queue);

        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }

    }
}
