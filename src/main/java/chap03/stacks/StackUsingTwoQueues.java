package chap03.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    public Queue<Integer> q1 = new LinkedList<>();
    public Queue<Integer> q2 = new LinkedList<>();

    public void push(Integer data)
    {
        q1.add(data);

        while(!q1.isEmpty())
            q2.add(q1.poll());

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public Integer pop()
    {
        if(q1.isEmpty())
            System.out.println("Queue is Stack");
        else
        {
            System.out.println("Pop :: " + q1.peek());
            return q1.poll();
        }
        return null;
    }

    public void printQueue()
    {
        System.out.print("Elements in Stack :: ");
        q1.forEach(p -> System.out.print(" "+ p));
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.printQueue();

        stack.pop();
        stack.pop();

        stack.printQueue();
    }
}
