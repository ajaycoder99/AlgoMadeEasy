package chap01.recursion;

import chap05.tree.BinaryTree;

import java.util.Arrays;
import java.util.Stack;

public class AdityaVermaRecursion {

    public static void printZeroToN(int n)
    {
        if(n == 0)
            return;

        printZeroToN(n-1);
        System.out.print(" " + n);
    }

    public static void printNToZero(int n)
    {
        if(n == 0)
            return;

        System.out.print(" " + n);
        printNToZero(n-1);
    }

    public static int heightOfBST(BinaryTree.Node node)
    {
        if(node == null)
            return 0;

        int left = heightOfBST(node.left);
        int right = heightOfBST(node.right);

        return Math.max(left,right) + 1;
    }

    public static void sortArray(int[] arr, int n)
    {
        if (n == 1)
            return;

        // Sort first n-1 elements
        sortArray( arr, n-1 );

        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n-1];
        int j = n-2;

    /* Move elements of arr[0..i-1], that are
      greater than key, to one position ahead
      of their current position */
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }

    public static void sortStack(Stack<Integer> stack)
    {
        if(!stack.isEmpty())
        {
            int x = stack.pop();
            sortStack(stack);
            sortedInsert(stack,x);
        }
    }

    public static void sortedInsert(Stack<Integer> stack, int x)
    {
        if(stack.isEmpty() || x > stack.peek())
        {
            stack.push(x);
            return;
        }

        int temp = stack.pop();
        sortedInsert(stack,x);

        stack.push(temp);

    }

    public static void deleteMiddleElementInStack(Stack<Integer> stack, int size, int current){
        if(stack.empty() || current == size)
            return;

        Integer currentElement = stack.pop();

        deleteMiddleElementInStack(stack,size,current+1);

        if(current != (size/2))
            stack.push(currentElement);
    }


    public static Stack<Integer> stack1;
    public static void reverseStackUsingRecursion()
    {
        if(stack1.empty())
            return;

            Integer current = stack1.pop();
            reverseStackUsingRecursion();
            pushAtEnd(current);
    }

    public static void pushAtEnd(Integer current)
    {
        if(stack1.isEmpty())
            stack1.push(current);
        else
        {
            Integer temp = stack1.pop();
            pushAtEnd(current);
            stack1.push(temp);
        }

    }

    public static void main(String[] args) {
        System.out.print("Print from 0 to N :: ");
        printZeroToN(7);
        System.out.print( "\n\n" );

        System.out.print("Print from N to 0 :: ");
        printNToZero(7);
        System.out.print( "\n\n" );

        BinaryTree tree = new BinaryTree(1);
        tree.insert(tree.root,2);
        tree.insert(tree.root,3);
        tree.insert(tree.root,4);
        tree.insert(tree.root,5);
        tree.insert(tree.root,6);
        tree.insert(tree.root,7);
        tree.insert(tree.root,8);
        tree.insert(tree.root,9);

        System.out.println("Height of BST :: " + heightOfBST(tree.root));
        System.out.print( "\n\n" );

        int[] arr = {3, 5, 1, 7, 9, 2, 4};
        sortArray(arr,arr.length);
        System.out.println("Sorted Array :: " + Arrays.toString(arr));
        System.out.print( "\n\n" );

        Stack<Integer> stack = new Stack<>();
        stack.push(6); stack.push(3); stack.push(1); stack.push(2);
        stack.push(7);stack.push(4);
        System.out.print("Sorted Input :: ");
        stack.forEach(p-> System.out.print(" "+p));
        System.out.print( "\n\n" );

        sortStack(stack);

        System.out.print( "\n\n" );
        System.out.print("Sorted Stack :: ");
        stack.forEach(p-> System.out.print(" "+p));
        System.out.print( "\n\n" );

        System.out.print("Delete Middle Element in Stack :: ");
        deleteMiddleElementInStack(stack,stack.size(),0);
        stack.forEach(p-> System.out.print(" "+p));
        System.out.print( "\n\n" );

        stack1 = stack;
        reverseStackUsingRecursion();
        System.out.print("Reverse Stack using Recursion ::");
        stack.forEach(p-> System.out.print(" "+p));
        System.out.print( "\n\n" );


    }
}
