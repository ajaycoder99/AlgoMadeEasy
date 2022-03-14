package chap02.linkedlist;

public class CircularLinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public Node() {
        }
    }

    public Node head;
    public int size;

    public CircularLinkedList() {
        size=0;
    }

    public void countNodesInLinkedList()
    {
        int len = 0;
        Node temp = head;
        Node firstElement = head;
        while(temp!=null)
        {
            temp = temp.next;
            len++;
            if(temp.next == firstElement)
            {
                len++;
                break;
            }
        }
        System.out.println("No. of Nodes in LinkedList ::" + len);
    }

    public void addNodeAtEnd(Node node)
    {
        Node temp = head;
        if(head == null)
        {
            head = node;
            head.next = head;
        }
        else
        {
            while(temp.next!=head )
            {
                temp = temp.next;
            }
            temp.next = node;
            node.next = head;
        }
        size++;
    }

    public void insertNodeAtStart(Node node)
    {
        Node temp = head;
        if(head == null)
            head = node;
        else
        {
            while(temp.next!=head)
            {
                temp = temp.next;
            }
            temp.next = node;
            node.next = head;
        }
        size++;
    }

    public void deleteLastNode()
    {
        Node temp = head;
        Node temp1 = head.next;
        while(temp1.next != head)
        {
            temp1 = temp1.next;
            temp = temp.next;
        }
        temp1 = null;
        temp.next = head;
        size--;
    }

    public void deleteFirstNode()
    {
        Node temp = head;
        while(temp.next!=head)
        {
            temp = temp.next;
        }
        temp.next = head.next;
        head = temp.next;
        size--;
    }

    public void printList()
    {
        System.out.print("Size :: " + size + " List :: " );
        Node temp = head;
        if (head != null)
        {
            do
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            while (temp != head);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addNodeAtEnd(new Node(1));
        list.addNodeAtEnd(new Node(2));
        list.addNodeAtEnd(new Node(3));
        list.addNodeAtEnd(new Node(4));
        list.addNodeAtEnd(new Node(5));

        list.printList();
        list.countNodesInLinkedList();
        System.out.println("Adding Node at start");
        list.insertNodeAtStart(new Node(10));
        list.printList();
        System.out.println("Deleting Last Node");
        list.deleteLastNode();
        list.printList();
        list.deleteFirstNode();
        list.printList();
    }

}
