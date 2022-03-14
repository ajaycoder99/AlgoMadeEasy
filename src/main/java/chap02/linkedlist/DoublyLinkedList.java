package chap02.linkedlist;

public class DoublyLinkedList {

    private static class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public DoublyLinkedList() {
        size = 0;
    }

    private Node head;
    private int size;

    public void addNodeAtEnd(Node node)
    {
        if(head == null)
            head = node;
        else
        {
            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
        size++;
    }

    public void addNodeAtBeginning(Node node)
    {
        if(head == null)
            head = node;
        else
        {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addNodeAtIdx(Node node, int idx)
    {
        Node temp = head;
        Node temp1 = head.next;

        int i = 0;
        while(i < idx - 1)
        {
            temp = temp.next;
            temp1 = temp1.next;
            i++;
        }
        temp.next = node;
        node.prev = temp;
        node.next = temp1;
        temp1.prev = node;
        size++;
    }

    public void addNodeAtMiddle(Node node)
    {
        Node temp = head;
        Node temp1 = head.next;
        Node tempEnd = head;
        while(tempEnd.next!=null && tempEnd.next.next!=null)
        {
            temp = temp.next;
            temp1 = temp.next;
            tempEnd = tempEnd.next.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = temp1;
        temp1.prev = node;
        size++;
    }

    public void deleteNodeAtStart()
    {
        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteNodeAtEnd()
    {
        Node temp = head;
        Node temp1 = head.next;
        while(temp1.next!=null)
        {
            temp = temp.next;
            temp1 = temp1.next;
        }
        temp.next = null;
        temp1.prev = null;
        size--;
    }

    public void deleteAtMatchedNode(Node node)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data == node.data)
            {
                if (head == null || temp == null)
                    return;

                /* If node to be deleted is head node */
                if (head == temp)
                    head = temp.next;

        /* Change next only if node to be deleted
            is NOT the last node */

                if (temp.next != null)
                    temp.next.prev = temp.prev;

        /* Change prev only if node to be deleted
            is NOT the first node */
                if (temp.prev != null)
                    temp.prev.next = temp.next;

                break;
            }
            temp = temp.next;
        }
    }

    public void printList()
    {
        System.out.print("Size ::" + size + " List Forward :: ");
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.print("Size ::" + size + " List Reverse :: ");

        temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addNodeAtBeginning(new Node(1));
        list.addNodeAtEnd(new Node(2));
        list.addNodeAtEnd(new Node(3));
        list.addNodeAtEnd(new Node(4));
        list.addNodeAtEnd(new Node(5));
        list.addNodeAtEnd(new Node(6));
        list.addNodeAtEnd(new Node(7));
        list.printList();
        System.out.println("Adding Node at index 3");
        list.addNodeAtIdx(new Node(10),3);
        list.printList();
        System.out.println("Adding Node at middle");
        list.addNodeAtMiddle(new Node(20));
        list.printList();
        System.out.println("Adding Node at middle");
        list.addNodeAtMiddle(new Node(30));
        list.printList();
        System.out.println("Deleting Node at start");
        list.deleteNodeAtStart();
        list.printList();
        System.out.println("Deleting Node at End");
        list.deleteNodeAtEnd();
        list.printList();
        System.out.println("Deleting Node 20 ");
        list.deleteAtMatchedNode(new Node(20));
        list.printList();
    }
}
