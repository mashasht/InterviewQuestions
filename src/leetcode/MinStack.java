package leetcode;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> min;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
           min.push(x);
        }
        else {
           if (x <= min.peek()) {
               min.push(x);
           }
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.empty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        int popped = stack.pop();
        if (popped == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if (stack.empty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.empty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return min.peek();
    }
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        System.out.println(ms.getMin());
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
