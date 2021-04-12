package main.stack;

public class VariableSizeStack<T> implements Stack<T> {

    private final double sizeMultiplier = 2; 

    private T[] stack;
    private int pointer = 0;


    /**
     * Constructor with specified start size
     * @param size start size of the stack
     */
    public VariableSizeStack(int size){
        stack = (T[]) new Object[size];
    }

    /**
     * Constructor with default start size of 8
     */
    public VariableSizeStack(){
        stack = (T[]) new Object[8];
    }

    @Override
    public void push(T node) {

        if(!(pointer == stack.length)){
            stack[pointer++] = node;
        } else {
            increaseStackSize();
            stack[pointer++] = node;
        }
        

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

    /**
     * Increase the size of the stack
     */
    private void increaseStackSize() {
        int newSize = (int) Math.floor(stack.length * sizeMultiplier);

        T[] newStack = (T[]) new Object[newSize];

        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;

    }
    
}
