package sai;

public class ArraySum {
    /**
     * Implement a recursive method in arrSumRec method that takes an integer array, two indices as arguements
     * calulate the sum from start to end of the array, and return the result.
     * Same for arrSumIter with iterative method
     */
    public static int arrSumRec(int[] arr, int start, int end) {

        if(end == 0 )
        {
            return arr[end];
        }
        else
        {
            return arr[end] + arrSumRec(arr, start, end-1);
        }

    }

    public static int arrSumIter(int[] arr, int start, int end) {
        if(start < 0 || end < 0)
        {
            return 0;
        }
        else
        {
            int sum = 0;

            for(start = 0; start <= end; start++)
            {
                sum = sum + arr[start];

            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println("Sum Recursive :: " + arrSumRec(new int[]{1,2,3,1,2,3},0,2));
        System.out.println("Sum Iterative :: " + arrSumIter(new int[]{1,2,3,1,2,3},0,2));
    }
}
