package chap04.queue;

import java.util.Stack;

public class LinkedListQueue {

    Node head;
    int size;

    private class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public LinkedListQueue() {
        size = 0;
    }

    public void enqueue(int data)
    {
       if(head == null)
       {
           Node temp = new Node(data);
           head = temp;
       }
       else
       {
           Node temp = head;
           while(temp.next!=null)
               temp = temp.next;

           temp.next = new Node(data);
       }
       size++;
    }

    public int deQueue()
    {
        if(head == null)
            System.out.println("Queue is Empty");
        else
        {
            Node temp = head;
            int data = temp.data;
            head = temp.next;
            System.out.println("Dequeue Element :: " + data);
            size--;
            return data;
        }
        return 0;
    }

    public void printQueue()
    {
        Node temp = head;
        if(head == null)
            System.out.println("Queue is Empty");
        else
        {
            System.out.print("Queue Elements are with size " + size +" :: ");
            while(temp!=null)
            {
                System.out.print(" " + temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public boolean isEmpty()
    {
        if(head == null)
            return true;
        return false;
    }

    public void reverseQueue(LinkedListQueue queue)
    {
        Stack stack = new Stack();

        while(!queue.isEmpty())
            stack.push(queue.deQueue());

        while(!stack.isEmpty())
        {
            Object object = stack.pop();
            Integer d = (Integer) object;
            int data = d.intValue();
            queue.enqueue(data);
        }

        System.out.println("Queue is reversed");
        queue.printQueue();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.printQueue();

        queue.deQueue();
        queue.deQueue();

        queue.printQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Queue before reverse");
        queue.printQueue();
        queue.reverseQueue(queue);
    }

}
