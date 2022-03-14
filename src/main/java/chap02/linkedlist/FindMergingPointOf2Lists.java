package chap02.linkedlist;

public class FindMergingPointOf2Lists {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNodeAtEnd(new LinkedList.Node(1));
        list.addNodeAtEnd(new LinkedList.Node(2));
        list.addNodeAtEnd(new LinkedList.Node(3));
        list.addNodeAtEnd(new LinkedList.Node(4));
        list.addNodeAtEnd(new LinkedList.Node(5));
        list.printLinkedList();
        System.out.println("List 1 size :: " + list.size);

        LinkedList list2 = new LinkedList();
        list2.addNodeAtEnd(new LinkedList.Node(10));
        list2.addNodeAtEnd(new LinkedList.Node(11));
        list2.addNodeAtEnd(new LinkedList.Node(12));
        list2.addNodeAtEnd(new LinkedList.Node(2));
        list2.addNodeAtEnd(new LinkedList.Node(3));
        list2.addNodeAtEnd(new LinkedList.Node(4));
        list2.addNodeAtEnd(new LinkedList.Node(5));

        list2.printLinkedList();
        System.out.println("List 2 size :: " + list2.size);

        int size1 = list.size;
        int size2 = list2.size;

        int i = 0;
        if(size2 > size1)
        {
            while(i < size2-size1 && list2.head.next!=null)
            {
                list2.head = list2.head.next;
                i++;
            }
            while(list.head.next!=null && list2.head.next!=null)
            {
                if(list2.head.data == list.head.data)
                {
                    System.out.println("Merging at :: " + list2.head.data);
                    break;
                }
                list.head = list.head.next;
                list2.head = list2.head.next;
            }
        }

    }
}
