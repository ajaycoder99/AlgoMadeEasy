package chap02.linkedlist;

public class InsertionSortLinkedList {

    static LinkedList.Node sorted;
    static LinkedList.Node head;

    public static void main(String[] args) {
       LinkedList list = new LinkedList();
       list.addNodeAtEnd(new LinkedList.Node(4));
        list.addNodeAtEnd(new LinkedList.Node(1));
        list.addNodeAtEnd(new LinkedList.Node(3));
        list.addNodeAtEnd(new LinkedList.Node(2));
        list.addNodeAtEnd(new LinkedList.Node(5));

        list.printLinkedList();

        LinkedList.Node node = insertionSort(list.head);
        list.head = node;
        list.printLinkedList();
    }

    public static LinkedList.Node insertionSort(LinkedList.Node head) {

        if(head == null )return head;

        LinkedList.Node dummy =new LinkedList.Node(Integer.MIN_VALUE);
        LinkedList.Node curr= head;
        LinkedList.Node prev = dummy;
        while(curr != null){
            if(prev.data > curr.data){
                prev = dummy;
            }
            while(prev.next != null && prev.next.data < curr.data){
                prev = prev.next;
            }
            LinkedList.Node temp =curr.next;
            curr.next =prev.next;
            prev.next =curr;
            curr =temp;
        }

        return dummy.next;
    }
}
