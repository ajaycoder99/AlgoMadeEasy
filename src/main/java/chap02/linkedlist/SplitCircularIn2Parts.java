package chap02.linkedlist;

public class SplitCircularIn2Parts {

    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        clist.addNodeAtEnd(new CircularLinkedList.Node(1));
        clist.addNodeAtEnd(new CircularLinkedList.Node(2));
        clist.addNodeAtEnd(new CircularLinkedList.Node(3));
        clist.addNodeAtEnd(new CircularLinkedList.Node(4));
        //clist.addNodeAtEnd(new CircularLinkedList.Node(5));

        clist.printList();

        CircularLinkedList.Node list1 = new CircularLinkedList.Node();
        CircularLinkedList.Node list2 = new CircularLinkedList.Node();

        CircularLinkedList.Node fastPtr = clist.head;
        CircularLinkedList.Node slowPtr = clist.head;

        while(fastPtr.next != clist.head && fastPtr.next.next!=clist.head)
        {
            //list1.addNodeAtEnd(new CircularLinkedList.Node(temp2.data));
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        if(fastPtr.next.next == clist.head)
        {
            fastPtr = fastPtr.next;
        }

        list1 = clist.head;
        if(clist.head.next != clist.head)
        {
             list2.next = slowPtr.next;
        }

        fastPtr.next = slowPtr.next;
        slowPtr.next = clist.head;

        /*if(i%2 == 1)
        {
            list1.addNodeAtEnd(new CircularLinkedList.Node(temp2.data));
        }

        do {
            list2.addNodeAtEnd(new CircularLinkedList.Node(temp2.next.data));
            temp2 = temp2.next;
        }
        while (temp2.next != clist.head);*/

        CircularLinkedList.Node node= list1;
        while(node.next!=list1)
        {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();

        node= list2;
        while(node.next!=list2)
        {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();

    }
}
