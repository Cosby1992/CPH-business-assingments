package main.stack;

public class Main {
    
    public static void main(String[] args) {
        
        Stack<Integer> stack = new VariableSizeStack<Integer>(10);

        // OBS two statements per line when adding elements to the stack
        stack.push(10); stack.push(10);
        stack.push(9); stack.push(9);
        stack.push(8); stack.push(8);
        stack.push(7); stack.push(7);
        stack.push(6); stack.push(6);
        stack.push(5); stack.push(5);
        stack.push(4); stack.push(4);
        stack.push(7); stack.push(7);
        stack.push(6); stack.push(6);
        stack.push(5); stack.push(5);
        stack.push(4); stack.push(4);
        
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
