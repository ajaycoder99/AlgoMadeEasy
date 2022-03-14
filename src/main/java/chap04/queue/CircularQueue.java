package chap04.queue;

public class CircularQueue {

    public int size, front, rear;
    public int[] queue;

    public CircularQueue(int size) {
        this.size = size;
        front = rear = -1;
        queue = new int[size];
    }

    public void enqueue(int data){

        if(front == -1) // Queue is empty
        {
            front = rear = 0;
            queue[front] = data;
        }
        else if((front == 0 && rear - 1 == size) || (front - 1 == rear % size)){ // Queue is Full
            System.out.println("Queue is Full");
        }
        else if(rear == size - 1 && front != 0){ // rear is at end and space is left at front
            rear = 0;
            queue[rear] = data;
        }
        else
        {
            rear++;
            if(front < rear)
                queue[rear] = data;
            else if(rear < front && rear != front)
            {
                queue[rear] = data;
            }

        }
    }

    public int dequeue()
    {
        int temp = 0;
        if(front == -1)
        {
            System.out.println("Queue is Empty");
        }
        else if(rear < front && rear >= 0)
        {
            temp = queue[rear];
            queue[rear] = Integer.MIN_VALUE;
            if(rear > 0)
                rear--;
            else
                rear = front;
        }
        else if(front < rear)
        {
            temp = queue[front];
            front++;
        }
        System.out.println("Dequeue Element :: " + temp);
        return temp;
    }

    public void printQueue()
    {
        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");
            return;
        }

        // If rear has not crossed the max size
        // or queue rear is still greater then
        // front.
        System.out.print("Elements in the " +
                "circular queue are: ");

        if(rear >= front)
        {

            // Loop to print elements from
            // front to rear.
            for(int i = front; i <= rear; i++)
            {
                System.out.print(queue[i]);
                System.out.print(" ");
            }
            System.out.println();
        }

        // If rear crossed the max index and
        // indexing has started in loop
        else
        {

            // Loop for printing elements from
            // front to max size or last index
            for(int i = front; i < size; i++)
            {
                System.out.print(queue[i]);
                System.out.print(" ");
            }

            // Loop for printing elements from
            // 0th index till rear position
            for(int i = 0; i <= rear; i++)
            {
                System.out.print(queue[i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.printQueue();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.printQueue();

        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        queue.printQueue();

        queue.enqueue(9);
    }

}
