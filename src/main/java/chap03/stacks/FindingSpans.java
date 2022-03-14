package chap03.stacks;

import java.util.Arrays;

public class FindingSpans {

    public static int[] findingSpans(int[] arr)
    {
        int[] spans = new int[arr.length];
        for(int i=0; i<arr.length ;i++)
        {
            int span = 1;
            int j = i - 1;
            while (j>=0 && arr[j] <= arr[j+1])
            {
                span++;
                j--;
            }
            spans[i] = span;
        }
        return spans;
    }

    public static int[] findingSpansUsingStack(int[] arr)  // Improved Complexity
    {
        int[] spans = new int[arr.length];
        IntegerStack stack = new IntegerStack();
        int p = 0;
        for(int i = 0; i < arr.length ; i++)
        {
            while (!stack.isEmpty() && arr[i] > arr[(Integer)stack.pop()])
                stack.pop();

            if(stack.isEmpty())
                p = -1;
            else
                p = (Integer)stack.pop();

            spans[i] = i-p;
            stack.push(i);
        }
        return spans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findingSpans(new int[]{6,3,4,5,2})));
        System.out.println(Arrays.toString(findingSpansUsingStack(new int[]{6,3,4,5,2})));
    }
}
