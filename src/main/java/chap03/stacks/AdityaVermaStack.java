package chap03.stacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

// https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2

public class AdityaVermaStack {

    // Problem 1 || Nearest Greatest To Right || NGR
    public static void nearestGreatestRightElement(int[] arr) {
        //int[] arr = {1,3,2,4};

        System.out.println("Input :: " + Arrays.toString(arr));

        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty())
                output[i] = -1;
            else if (!stack.isEmpty() && stack.peek() > arr[i])
            {
                output[i] = stack.peek();
            }
            else if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    output[i] = -1;
                else
                    output[i] = stack.peek();
            }
            stack.push(arr[i]);

          /*  System.out.print(" " + arr[i] + "---");
            stack.forEach(p -> System.out.print(" " + p));
            System.out.println();*/
        }

        System.out.println("NGR ::" + Arrays.toString(output));
    }

    // Problem 2 || Nearest Greatest To Left || NGL
    public static void nearestGreatestLeftElement(int[] arr) {
        //int[] arr = {1,3,2,4};

        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                output[i] = -1;
            else if (!stack.isEmpty() && stack.peek() > arr[i])
                output[i] = stack.peek();
            else if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    output[i] = -1;
                else
                    output[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        System.out.println("NGL ::" + Arrays.toString(output));
    }

    // Problem 3 || Nearest Smaller to left || NSL
    public static void nearestSmallerLeftElement(int[] arr) {
        //int[] arr = {1,3,2,4};

        //int[] arr = {4,5,2,10,8};

        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                output[i] = -1;
            else if (!stack.isEmpty() && stack.peek() < arr[i])
                output[i] = stack.peek();
            else if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    output[i] = -1;
                else
                    output[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        System.out.println("NSL ::" + Arrays.toString(output));
    }

    // Problem 4 || Nearest Smaller to right || NSR
    public static void nearestSmallerRightElement(int[] arr) {
        //int[] arr = {1,3,2,4};

        //int[] arr = {6, 2, 5, 4, 5, 1, 6};

        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty())
                output[i] = -1;
            else if (!stack.isEmpty() && stack.peek() < arr[i])
                output[i] = stack.peek();
            else if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    output[i] = -1;
                else
                    output[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        System.out.println("NSR ::" + Arrays.toString(output));

    }

    // Problem 5 || Stock Span Problem || Pattern :; NGL
    public static void findStockSpan() {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("input stock price :: " + Arrays.toString(arr));

        int[] output = new int[arr.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                output[i] = -1;
            else if (!stack.isEmpty() && stack.peek()[0] > arr[i])
                output[i] = stack.peek()[1];
            else if (!stack.isEmpty() && stack.peek()[0] <= arr[i]) {
                while (!stack.isEmpty() && stack.peek()[0] <= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    output[i] = -1;
                else
                    output[i] = stack.peek()[1];
            }

            stack.push(new int[]{arr[i], i});
        }

        for (int i = 0; i < output.length; i++)
            output[i] = i - output[i];

        System.out.println("Stock Span ::" + Arrays.toString(output));
    }


    // Problem 6 || Largest Area in Histogram || Pattern NSL & NSR
    public static int findLargestAreaInHistogram(int[] arr) {
       // System.out.println("findLargestAreaInHistogram() started...!!!");

        //int arr[] = { 6, 2, 5, 4, 5, 1, 6};
        System.out.println("input ::" + Arrays.toString(arr));
        Stack<int[]> stack = new Stack<>();

        int leftArr[] = new int[arr.length];
        int rightArr[] = new int[arr.length];

        int psuedoIndex = -1;

        // NSL
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                leftArr[i] = psuedoIndex;
            else if (!stack.isEmpty() && stack.peek()[0] < arr[i])
                leftArr[i] = stack.peek()[1];
            else if (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                while (!stack.isEmpty() && stack.peek()[0] >= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    leftArr[i] = psuedoIndex;
                else
                    leftArr[i] =  stack.peek()[1];
            }
            stack.push(new int[]{arr[i], i});
        }

        System.out.println("Left Array NSL Index :: " + Arrays.toString(leftArr));

        stack = new Stack<>();
        psuedoIndex = arr.length;

        // NSR
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty())
                rightArr[i] = psuedoIndex;
            else if (!stack.isEmpty() && stack.peek()[0] < arr[i])
                rightArr[i] = stack.peek()[1];
            else if (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                while (!stack.isEmpty() && stack.peek()[0] >= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    rightArr[i] = psuedoIndex;
                else
                    rightArr[i] =  stack.peek()[1];
            }
            stack.push(new int[]{arr[i], i});
        }

        System.out.println("Right Array NSR Index :: " + Arrays.toString(rightArr));

        int[] width = new int[arr.length];
        int[] area = new int[arr.length];
        int maxArea = 0;


        for (int i = 0; i < arr.length; i++) {
            width[i] = rightArr[i] - leftArr[i] - 1;
            area[i] = arr[i] * width[i];

            if (maxArea < area[i])
                maxArea = area[i];

        }

        //System.out.println("Largest Area in Histogram :: " + maxArea);

        // System.out.println("findLargestAreaInHistogram() end...!!!");

        return maxArea;

    }

    // Problem 7 : Rain water trapping
    public static void rainWaterTrapping()
    {

        System.out.println("Rain Water Trapping :::: ");
        int arr[] = {3,0,0,2,0,4};

        System.out.println("Input :: " + Arrays.toString(arr));

        int maxArrFromLeft[] = new int[arr.length];
        int maxArrFromRight[] = new int[arr.length];

        maxArrFromLeft[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++)
        {
            maxArrFromLeft[i] = Math.max(maxArrFromLeft[i-1],arr[i]);
        }

        maxArrFromRight[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length - 2 ; i >= 0 ; i--)
        {
            maxArrFromRight[i] = Math.max(maxArrFromRight[i+1],arr[i]);
        }

        System.out.println("Max Area from Left :: "+Arrays.toString(maxArrFromLeft));
        System.out.println("Max Area from Right :: "+Arrays.toString(maxArrFromRight));

        int[] waterArr = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++)
            waterArr[i] = Math.min(maxArrFromLeft[i],maxArrFromRight[i]) - arr[i];

        int sum = 0;
        for (int i : waterArr)
            sum = sum + i;

        System.out.println("Water Trapped :: " + sum);

    }

    public static void main(String[] args) {

        //int[] arr = {1 , 3 , 2 , 4};
        int arr[] = {6, 2, 5, 4, 5, 1, 6};

        nearestGreatestRightElement(arr);

        nearestGreatestLeftElement(arr);

        nearestSmallerLeftElement(arr);

        nearestSmallerRightElement(arr);

        findStockSpan();

        System.out.println("Finding Largest Area in Histogram :::: ");

        int arr1[] = {6, 2, 5, 4, 5, 1, 6};
        findLargestAreaInHistogram(arr1);

        System.out.println("Finding Max Area of Rectangle :::: ");

        int[][] matrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        System.out.println("Max Area in Rectangle :: " + Integer.max(Integer.max(findLargestAreaInHistogram(matrix[0]), findLargestAreaInHistogram(matrix[1])),
                Integer.max(findLargestAreaInHistogram(matrix[2]), findLargestAreaInHistogram(matrix[3]))));

        rainWaterTrapping();

    }
}
