package chap03.stacks;

import java.util.Arrays;

public class ArrayWithTwoStacks {

    int[] arr;
    int size;
    int top1;
    int top2;

    public ArrayWithTwoStacks(int size) {
        this.size = size;
        this.arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push1(int data)
    {
        if(top1 < top2 - 1)
        {
            arr[++top1] = data;
        }
        else
        {
            System.out.println("Stack Underflow");
        }
    }

    public void push2(int data)
    {
        if(top1 < top2 - 1)
        {
            arr[--top2] = data;
        }
        else
        {
            System.out.println("Stack Overflow");
        }
    }

    public int pop1()
    {
        if(top1 > -1 )
        {
            int data = arr[top1];
            arr[top1--] = 0;
            return data;
        }
        else {
            System.out.println("Stack1 is Underflow");
            System.exit(0);
        }
        return 0;
    }

    public int pop2()
    {
        if(top2 != size)
        {
            int data = arr[top2];
            arr[top2++] = 0;
            return data;
        }
        else
        {
            System.out.println("Stack2 is Underflow");
            System.exit(0);
        }
        return 0;
    }

    public void print(int[] arr)
    {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        ArrayWithTwoStacks stack = new ArrayWithTwoStacks(5);
        stack.push1(1);
        stack.push1(2);
        stack.push2(3);
        stack.print(stack.arr);

        System.out.println("Pop :: " + stack.pop2());
        stack.print(stack.arr);

        stack.push1(10);
        stack.push2(4);
        stack.push2(5);
        stack.print(stack.arr);

        System.out.println("Pop :: " + stack.pop1());
        stack.print(stack.arr);

        stack.pop2();
        stack.pop2();
        //stack.pop2();

        stack.print(stack.arr); System.out.print("Top1 :: " + stack.top1); System.out.print("Top2 :: " + stack.top2);
    }


}
