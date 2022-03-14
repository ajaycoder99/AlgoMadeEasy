package chap03.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackUsingLinkedList<T> implements Iterable<T>{

    static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    Node<T> head;
    int size;

    public StackUsingLinkedList() {
        size = 0;
    }

    public void push(T data)
    {
        Node<T> node = new Node<T>(data);
        if (head != null) {
            node.next = head;
        }
        head = node;
        //System.out.println("Push :: " + node.data);
        size++;
    }

    public T pop()
    {
        if(head == null)
        {
            System.out.println("Stack is Empty");
            return null ;
        }

        Node<T> temp = head;
        head = head.next;
        size--;
        System.out.print(temp.data);
        return temp.getData();
    }

    public T top()
    {
        if(head == null)
        {
            System.out.println("Stack is Empty");
            return null ;
        }

        Node<T> temp = head;
        head = head.next;
        return temp.getData();
    }

    public T popWithNoPrint()
    {
        if(head == null)
        {
            System.out.println("Stack is Empty");
            return null ;
        }

        Node<T> temp = head;
        head = head.next;
        size--;
        return temp.getData();
    }

    public Iterator<T> iterator() {
        return new LinkedIterator(head);
    }

    private class LinkedIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.data;
            current = current.next;
            return item;
        }
    }

    public void printStack()
    {
        Node<T> temp = head;

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
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
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

    }
}
