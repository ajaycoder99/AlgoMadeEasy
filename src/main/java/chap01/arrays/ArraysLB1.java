package chap01.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLB1 {

    public static void main(String[] args) {
        // takeUserInputForArr();

        int[] arr = {3,2,5,6,8,1,9};
        recursiveBubbleSort(arr,7);
        System.out.println(Arrays.toString(arr));

        sort012();

        moveAllNegToLeft();

        reverseArray(new int[]{3,2,5,6,8,1,9});
    }

    public static void takeUserInputForArr()
    {
        // Take input for 10 elements in Array
        System.out.println("Enter 10 Elements to add in Array");
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        int i = 0;
        while ( i < 10)
        {
            array[i] = scanner.nextInt();
            i++;
        }
        scanner.close();
        System.out.println(Arrays.toString(array));
    }

    public static void recursiveBubbleSort(int[] arr, int n)
    {
        if(n == 1)
            return;

        // Putting max element at end
        for(int i = 0; i < n - 1; i++)
        {
            if(arr[i] > arr[i+1])
            {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
        }
        // Sorting remaining array
        recursiveBubbleSort(arr,n-1);
    }

    public static void sort012()
    {
        int[] arr = {0,2,1,1,0,2,0};
        int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // Count the number of 0s, 1s and 2s in the array
        for (i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    cnt0++;
                    break;
                case 1:
                    cnt1++;
                    break;
                case 2:
                    cnt2++;
                    break;
            }
        }

        // Update the array
        i = 0;

        // Store all the 0s in the beginning
        while (cnt0 > 0) {
            arr[i++] = 0;
            cnt0--;
        }

        // Then all the 1s
        while (cnt1 > 0) {
            arr[i++] = 1;
            cnt1--;
        }

        // Finally all the 2s
        while (cnt2 > 0) {
            arr[i++] = 2;
            cnt2--;
        }

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    public static void moveAllNegToLeft()
    {
        int[] arr = {-1,2,3,-4,-8,9,10,8};
        int temp,j=0;

        for(int i=0; i < arr.length; i++ ){
            if(arr[i] < 0 )
            {
                if(i != j){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }

        System.out.println(Arrays.toString(arr)+"\n");
    }

    public static void reverseArray(int[] arr)
    {
        System.out.println("Input Array :: " + Arrays.toString(arr));
        for(int i=0 ; i < arr.length/2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println("Reversed Array :: " + Arrays.toString(arr));
    }
}
