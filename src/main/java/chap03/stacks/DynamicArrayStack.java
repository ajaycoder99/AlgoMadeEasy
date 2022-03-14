package chap03.stacks;

public class DynamicArrayStack {

    private int capacity;
    private int[] stack;
    private int top;

    public DynamicArrayStack(int capacity) {
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
            expandStack();
        else
        {
            stack[++top] = data;
        }
    }

    public void expandStack()
    {
        capacity = capacity * 2;
        System.out.println("Expanded array to capacity :: " + capacity);
        int[] temp = new int[capacity];
        int j = 0;
        for(int val : stack)
            temp[j++] = val;
        stack = temp;
    }

    public void shrink()
    {
        capacity = capacity / 2;
        System.out.println("Shrink array to capacity :: " + capacity);
        int[] temp = new int[capacity];
        int j = 0;
        for(int i = 0; i < top + 1 ; i++)
            temp[j++] = stack[i];
        stack = temp;
    }

    public int pop() throws Exception
    {
        if(isEmpty())
            throw new Exception("Stack is Empty");
        else
        {
            if(capacity > 4)
            if(getSize() < capacity / 4)
                shrink();

            System.out.println("Pop() :: " + stack[top]);
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
            System.out.printf("Stack Elements with capacity [%d] :: " , capacity);
            for(int i = 0 ; i < top + 1 ; i++)
                System.out.print(stack[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        DynamicArrayStack stack = new DynamicArrayStack(2);
        stack.push(1);
        stack.push(2);
        stack.printStack(stack.getStack());

        stack.pop();
        stack.push(7);
        stack.push(8);
        stack.printStack(stack.getStack());

        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        stack.push(17);
        stack.printStack(stack.getStack());

        stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();
        stack.printStack(stack.getStack());

    }
}
