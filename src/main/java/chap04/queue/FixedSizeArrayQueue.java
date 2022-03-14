package chap04.queue;

import java.util.Queue;

public class FixedSizeArrayQueue {

    int queue[];
    int front, rear;

    private int CAPACITY = 16;

    FixedSizeArrayQueue(int c)
    {
        front = rear = 0;
        CAPACITY = c;
        queue = new int[CAPACITY];
    }


    public void enqueue(int data)
    {
        if (CAPACITY == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }
        else {
            queue[rear] = data;
            rear++;
        }
        return;
    }

    public void queueDequeue()
    {
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }

            if (rear < CAPACITY)
                queue[rear] = 0;

            rear--;
        }
        return;
    }

    public void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }

        for (i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
        return;
    }

    public void queueFront()
    {
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
        return;
    }

    public static void main(String[] args) {
        FixedSizeArrayQueue queue = new FixedSizeArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.queueDisplay();

        queue.queueDequeue();
        System.out.println();
        queue.queueDisplay();
    }
}
