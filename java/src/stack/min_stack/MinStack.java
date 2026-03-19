package stack.min_stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val <= getMin()){ // if new value is smaller than current min push to min stack
            minStack.push(val);
        } 

    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        if (getMin() == top) minStack.pop();

    }
    
    public int top() {
        return stack.peek();
    
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
