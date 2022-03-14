package chap05.tree;

import java.util.*;

public class BabbarQsMediumBT {

    public static void main(String[] args) {
        BinaryTree tree = createBinaryTree();
        BinaryTree.Node root = tree.root;

        tree.printVerticalOrder();
        System.out.println();

        System.out.print("Print Top View :: ");
        BinaryTree.topView(tree.root);
        System.out.println();

        Tree btree = createTree();
        System.out.print("Print Bottom View ::");
        btree.bottomView();
        System.out.println();

        System.out.print("Print Left View :: ");
        tree.leftView();
        System.out.println();

        System.out.print("Print Right View :: ");
        tree.rightView();
        System.out.println();

        BinaryTree.NthInorder(root,6);
    }

    public static BinaryTree createBinaryTree()
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node(1);
        BinaryTree.Node root = tree.root;
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.right.left = new BinaryTree.Node(6);
        root.right.right = new BinaryTree.Node(7);
        root.right.left.right = new BinaryTree.Node(8);
        root.right.right.right = new BinaryTree.Node(9);
        return tree;
    }

    public static Tree createTree()
    {
        Node root1 = new Node(20);
        root1.left = new Node(8);
        root1.right = new Node(22);
        root1.left.left = new Node(5);
        root1.left.right = new Node(3);
        root1.right.left = new Node(4);
        root1.right.right = new Node(25);
        root1.left.right.left = new Node(10);
        root1.left.right.right = new Node(14);
        Tree btree = new Tree(root1);
        return btree;
    }
}
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

//Tree class
class Tree
{
    Node root; //root node of tree

    // Default constructor
    public Tree() {}

    // Parameterized tree constructor
    public Tree(Node node)
    {
        root = node;
    }

    // Method that prints the bottom view.
    // https://www.geeksforgeeks.org/bottom-view-binary-tree/
    public void bottomView()
    {
        if (root == null)
            return;

        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;

        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue to store tree nodes in level order traversal
        Queue<Node> queue = new LinkedList<Node>();

        // Assign initialized horizontal distance value to root
        // node and add it to the queue.
        root.hd = hd;
        queue.add(root);

        // Loop until the queue is empty (standard level order loop)
        while (!queue.isEmpty())
        {
            Node temp = queue.remove();

            // Extract the horizontal distance value from the
            // dequeued tree node.
            hd = temp.hd;

            // Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
            map.put(hd, temp.data);

            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd+1.
            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        // Extract the entries of map into a set to traverse
        // an iterator over that.
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        // Make an iterator
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        // Traverse the map elements using the iterator.
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }
}