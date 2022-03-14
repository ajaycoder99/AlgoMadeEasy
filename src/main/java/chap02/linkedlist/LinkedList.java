package chap02.linkedlist;

import javax.lang.model.util.Elements;

public class LinkedList {

    public Node head;
    public int size;

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static class Node
    {
        public int data;
        public Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }

        public Node() {
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

    public LinkedList() {
        this.size = 0;
    }

    public void addNodeAtEnd(Node node)
    {
        if(head == null)
            head = node;
        else
        {
            Node last = head;
            while(last.next != null)
            {
                last = last.next;
            }
            last.next = node;
        }
        size++;
    }

    public void addNodeAtStart(Node node)
    {
         Node root = head;
         node.setNext(root);
         head = node;
         size++;
    }

    public void addNodeAtIdx(Node node,int idx)
    {
        if(size == 1)
        {
            head = node;
        }

        Node temp=head,tempNext=head.next;
        int i = 0;
        while(i < idx - 1)
        {
            temp = temp.next;
            tempNext = tempNext.next;
            i++;
        }
        temp.next = node;
        node.next = tempNext;
        size++;
    }

    public void addNodeAtMiddle(Node node)
    {
        if(head == null)
            head = node;
        else if(head.next == null)
            head.next = node;
        else {
            Node temp = head;
            Node temp1 = head;
            while(temp1.next!=null && temp1.next.next !=null)
            {
                temp = temp.next;
                temp1 = temp1.next.next;
            }
            temp1 = temp.next;
            temp.next = node;
            node.next = temp1;
        }
        size++;
    }

    public void deleteFirstNode()
    {
        Node temp = head;
        head = temp.next;
        size--;
    }

    public void deleteLastNode()
    {
        Node temp = head;
        Node temp1 = head.next;
        while(temp1.next!=null)
        {
            temp1 = temp1.next;
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void deleteAtIdx(int idx)
    {
        int i = 0;
        Node temp = head;
        Node temp1 = head.next;
        while(i < idx - 1)
        {
            temp = temp.next;
            temp1 = temp1.next;
            i++;
        }
        temp.next = temp1.next;
        size--;
    }

    public void deleteMatchedNode(Node node)
    {
        Node temp = head;
        Node temp1 = head.next;
        while(temp.next!=null)
        {
            if(temp.data == node.data)
            {
                temp.data = temp1.data;
                temp.next = temp1.next;
                temp1 = temp1.next;
                size--;
                break;
            }
            else
            {
                temp = temp.next;
                temp1 = temp1.next;
            }
        }
        temp.next = temp1;
    }

    public void findNthElementFromEnd(int n)
    {
        Node temp = head;
        Node temp1 = head;
        int i = 1;

        if(head == null)
        {
            System.out.println("Element not found");
            return;
        }

        while(temp.next!=null)
        {
            if(i >= n)
            {
                temp1 = temp1.next;
            }

            temp = temp.next;
            i++;
        }
        if(temp1 != null)
            System.out.printf("Element at %d from end is %d " , n , temp1.data );

    }

    /* Important */
    public void reverseIterative()
    {
        System.out.println("reverse Iteratively");
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Node reverseLinkedListRecursive(Node node){

        if (node == null || node.next == null)
            return node;

        /* reverse the rest list and put
        the first element at the end */
        Node rest = reverseLinkedListRecursive(node.next);
        node.next.next = node;

        /* tricky step -- see the diagram */
        node.next = null;

        /* fix the node pointer */
        return rest;

    }

    /* Important */

    static int count = 0;
    static int data;
    static void findNthFromLast(Node head, int n,
                                Node nth_last)
    {
        // if list is empty
        if (head == null)
            return;

        // recursive call
        findNthFromLast(head.next, n, nth_last);

        // increment count
        count = count + 1;

        // if true, then head is the
        // nth node from the last
        if (count == n)
        {
            data = head.data;
        }
    }

    // utility function to find
    // the nth node from the last
    // of the linked list
    public void findNthFromLastUtil(Node head, int n)
    {
        // Initialize
        Node nth_last = new Node();
        count = 0;

        // find nth node from the last
        findNthFromLast(head, n, nth_last);

        // if node exists, then print it
        if (nth_last != null)
            System.out.println("Nth node from last is: " +
                    data);
        else
            System.out.println("Node does not exists");
    }

    Node left;
    public boolean checkIfPalindrome(Node right)
    {
        left = head;

        if(right == null)
            return true;

        boolean isp = checkIfPalindrome(right.next);
        if(isp == false)
            return false;

        boolean tempboolean = (left.data == right.data);

        left = left.next;

        return tempboolean;
    }

    public Node fractionalNodes(int k)
    {
        // Corner cases
        if (k <= 0 || head == null)
            return null;

        Node fractionalNode = null;

        // Traverse the given list
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next){

            // For every k nodes, we move
            // fractionalNode one step ahead.
            if (i % k == 0){

                // First time we see a multiple of k
                if (fractionalNode == null)
                    fractionalNode = head;
                else
                    fractionalNode = fractionalNode.next;
            }
            i++;
        }
        return fractionalNode;
    }

    void printLinkedList()
    {
        Node tnode = head;
        System.out.print("LinkedList Size :: " + size + " List :: ");
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNodeAtEnd(new Node(2));
        list.addNodeAtEnd(new Node(3));
        list.addNodeAtEnd(new Node(4));
        list.addNodeAtEnd(new Node(5));
        list.addNodeAtEnd(new Node(6));
        list.addNodeAtEnd(new Node(7));
        list.addNodeAtEnd(new Node(8));

        list.addNodeAtStart(new Node(1));

        list.addNodeAtIdx(new Node(10),2);
        list.printLinkedList();

        System.out.println("Adding Node at Middle");
        list.addNodeAtMiddle(new Node(20));
        list.printLinkedList();

        System.out.println("Adding Node at Middle");
        list.addNodeAtMiddle(new Node(30));
        list.printLinkedList();

        System.out.println("Deleting First Node");
        list.deleteFirstNode();
        list.printLinkedList();

        System.out.println("Deleting Last Node");
        list.deleteLastNode();
        list.printLinkedList();

        System.out.println("Deleting at index 3");
        list.deleteAtIdx(2);
        list.printLinkedList();

        System.out.println("Deleting matched node with data 10");
        list.deleteMatchedNode(new Node(10));
        list.printLinkedList();

        list.findNthElementFromEnd(2);
        list.findNthFromLastUtil(list.head,2);
        list.reverseIterative();
        list.printLinkedList();

        System.out.println("Recursive reverse");
        Node temp = list.head;
        list.head = list.reverseLinkedListRecursive(temp);
        list.printLinkedList();

        LinkedList list1 = new LinkedList();
        list1.addNodeAtEnd(new Node(1));
        list1.addNodeAtEnd(new Node(2));
        list1.addNodeAtEnd(new Node(3));
        list1.addNodeAtEnd(new Node(2));
        list1.addNodeAtEnd(new Node(1));
        list1.printLinkedList();
        System.out.println("Is Palindrome ::" + list.checkIfPalindrome(list1.head));

        //find fractional node n/k n = length and k > 0
        list.printLinkedList();
        System.out.println("Fractional Node :: " + list.fractionalNodes(2).data);

    }
}
