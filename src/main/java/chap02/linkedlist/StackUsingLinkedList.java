package chap02.linkedlist;

public class StackUsingLinkedList {

    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public StackUsingLinkedList() {
        size = 0;
    }

    public void push(Node node)
    {
        if (head != null) {
            node.next = head;
        }
        head = node;
        System.out.println(" push " + node.data);
        size++;
    }

    public Node pop()
    {

        if(head == null)
        {
            System.out.println("Stack is Empty");
            return null ;
        }

        Node temp = head;
        head = head.next;
        size--;
        System.out.println("Pop :: " + temp.data);
        return temp;
    }

    /*Important*/

    public void detectLoop()
    {
        Node temp1 = head;
        Node temp2 = head;
        int flag = 0;
        while(temp1!=null && temp2!=null && temp2.next!=null)
        {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
            if(temp1 == temp2)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 1 )
        {
            System.out.println("Loop Found");
            temp1 = head;
            while (temp1 != temp2)
            {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            System.out.println("Start of Loop is at :: " + temp1.data);
        }
        else
            System.out.println("No Loop");

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
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(new Node(1));
        stack.push(new Node(2));
        
        stack.pop();

        stack.printStack();

        stack.push(new Node(3));
        stack.push(new Node(4));
        
        //stack.pop();
        
        stack.push(new Node(5));
        stack.push(new Node(6));
        stack.push(new Node(7));
        
        //stack.pop();stack.pop();stack.pop();

        stack.printStack();

        // Creating Loop Manually
        stack.head.next.next.next = stack.head.next;
        stack.detectLoop();

    }
}
