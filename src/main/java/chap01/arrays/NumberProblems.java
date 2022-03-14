package chap01.arrays;

import chap04.queue.QueueUsingTwoStacks;

import java.util.*;

public class NumberProblems {

    // https://www.geeksforgeeks.org/window-sliding-technique/

    public static int findMaxWindow(int[] arr, int k)
    {
        // findMaxWindow(new int[]{1,2,7,3,1}, 3)

        int windowSum = 0;
        int maxSum = 0;

        for(int i = 0 ; i < k ; i++)
        {
            windowSum = windowSum + arr[i];
        }

        for(int i = k ; i < arr.length ; i++)
        {
            windowSum = windowSum - arr[i-k] + arr[i] ;
            maxSum = Integer.max(windowSum,maxSum);
        }
        return maxSum;
    }

    // https://www.geeksforgeeks.org/check-if-stack-elements-are-pairwise-consecutive/

    public static boolean checkIfPairsAreConsecutiveInStack(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        while(tempStack.size() > 1)
        {
            int x = tempStack.pop();
            int y = tempStack.pop();

            if(Math.abs(x-y) != 1)
                return false;

            stack.push(x);
            stack.push(y);
        }

        if (tempStack.size() == 1)
            stack.push(tempStack.peek());

        return true;
    }

    public static void reverseQfirstKElements(Queue<Integer> queue, int k) {
        if (queue.isEmpty() == true || k > queue.size())
            return;
        if (k <= 0)
            return;

        System.out.println("Elements in Queue :: ");
        queue.forEach(p -> System.out.print(" " + p));
        System.out.println();

        Stack<Integer> stack = new Stack<Integer>();

        // Push the first K elements into a Stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.peek());
            queue.remove();
        }

        // Enqueue the contents of stack
        // at the back of the queue
        while (!stack.empty()) {
            queue.add(stack.peek());
            stack.pop();
        }

        // Remove the remaining elements and enqueue
        // them at the end of the Queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.peek());
            queue.remove();
        }

        System.out.println("Elements in Queue after reversing k elements :: ");
        queue.forEach(p -> System.out.print(" " + p));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(findMaxWindow(new int[]{1,2,7,3,1}, 3));

        Stack<Integer> s = new Stack<Integer> ();
        s.push(4);
        s.push(5);
        s.push(-2);
        s.push(-3);
        s.push(11);
        s.push(10);
        s.push(5);
        s.push(6);
        s.push(20);

        System.out.println("Check if Consecutive :: " + checkIfPairsAreConsecutiveInStack(s));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        reverseQfirstKElements(queue,2);

        // Call by value // coz long is primitive
        NumberProblems n = new NumberProblems();
        long[] a1 = {3,4,5};
        long[] a2 = n.fix(a1);

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

        // Call by reference // coz String is object
        String s1 = "slip";
        String s2 = n.fix(s1);
        System.out.println(s1 + " " + s2);

    }

    public long[] fix(long[] a3){
        a3[1] = 7;
        return a3;
    }

    public String fix(String a3){
        a3 = a3 + "stream";
        System.out.println(a3 + " ");
        return "stream";
    }

}
