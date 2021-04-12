package main.stack;

public class FixedSizeStack<T> implements Stack<T> {

    private T[] stack;
    private int pointer = 0;

    public FixedSizeStack(int size){
        stack = (T[]) new Object[size];
    }

    @Override
    public void push(T node) {

        stack[pointer++] = node;

    }

    @Override
    public T pop() {

        if(pointer > 0){
            return stack[--pointer];
        } else {
            // handle exception
            return null;
        }

        
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }
    
}
