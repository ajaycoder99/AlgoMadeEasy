package chap04.queue;

import java.util.Stack;

public class QueueUsingTwoStacks {

    public Stack<Integer> s1 = new Stack<>();
    public Stack<Integer> s2 = new Stack<>();

    public void enqueue(Integer data)
    {
        while (!s1.isEmpty())
            s2.push(s1.pop());

        s1.push(data);

        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    public Integer dequeue()
    {
        if (s1.isEmpty())
            System.out.println("Queue is empty");
        else
        {
            System.out.println("Dequeue :: " + s1.peek());
            return s1.pop();
        }
        return null;
    }

    public void printQueue()
    {
        System.out.println("Printing Elements in Queue :: ");
        s1.forEach(p -> System.out.print(" " + p));
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.printQueue();

        queue.dequeue();
        queue.dequeue();

        queue.printQueue();
    }
}
