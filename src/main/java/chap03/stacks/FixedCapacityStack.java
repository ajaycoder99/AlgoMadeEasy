package chap03.stacks;

import java.util.Arrays;

public class FixedCapacityStack {

    private int capacity;
    private int[] stack;
    private int top;

    public FixedCapacityStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void push(int data) throws Exception
    {
        System.out.println("Push() :: " + data);
        if(isFull())
            throw new Exception("Stack is full");
        else
        {
            stack[++top] = data;
        }
    }

    public int pop() throws Exception
    {
        if(isEmpty())
            throw new Exception("Stack is Empty");
        else
        {
            return stack[top--];
        }
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull()
    {
        return capacity == top + 1;
    }

    public int getSize()
    {
        return top + 1;
    }

    public void printStack(int[] stack)
    {
        if(top == -1)
            System.out.println("Stack is Empty");
        else
        {
            System.out.println("Stack Elements :: ");
            for(int i = stack.length-1;i >= 0;i--)
            {
                System.out.print( stack[i] + " | ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        FixedCapacityStack stack = new FixedCapacityStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.printStack(stack.getStack());

        System.out.println("Stack pop() :: " + stack.pop());
        System.out.println("Stack size :: " + stack.getSize());
        stack.push(7);
        stack.push(8);

        stack.printStack(stack.getStack());

    }
}
