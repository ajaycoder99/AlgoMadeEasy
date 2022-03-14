package chap03.stacks;

public class IntegerStack {

    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node head;
    int size;

    public IntegerStack() {
        size = 0;
    }

    public void push(int data)
    {
        Node node = new Node(data);
        if (head != null) {
            node.next = head;
        }
        head = node;
        //System.out.println("Push :: " + node.data);
        size++;
    }

    public int pop()
    {
        if(head == null)
        {
            System.out.println("Stack is Empty");
            return 0 ;
        }

        Node temp = head;
        head = head.next;
        size--;
        System.out.print(temp.data);
        return temp.getData();
    }

    public int top()
    {
        if(head == null)
        {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE ;
        }

        Node temp = head;
        return temp.getData();
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    /* Important */
    public void reverseStack(IntegerStack stack)
    {
        if(stack.isEmpty())
            return;

        int temp = stack.pop();
        reverseStack(stack);
        insertAtBotton(stack,temp);
    }

    public void insertAtBotton(IntegerStack stack, int data)
    {
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        insertAtBotton(stack,data);
        stack.push(temp);

    }

    public int popWithNoPrint()
    {
        if(head == null)
        {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }

        Node temp = head;
        head = head.next;
        size--;
        return temp.getData();
    }

    public void printStack()
    {
        Node temp = head;

        if (head == null)
        {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.print(" Stack Size :: " + size + " Elements :: ");
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();
        stack.push(1);
        stack.push(2);

        stack.pop();

        stack.printStack();

        stack.push(3);
        stack.push(4);

        //stack.pop();

        stack.push(5);
        stack.push(6);
        stack.push(7);

        //stack.pop();stack.pop();stack.pop();

        stack.printStack();
        stack.reverseStack(stack);
        stack.printStack();
    }
}
