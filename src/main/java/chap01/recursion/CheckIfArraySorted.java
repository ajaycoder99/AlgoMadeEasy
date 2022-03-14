package chap01.recursion;

public class CheckIfArraySorted {

    public static boolean isSorted(int[] arr, int idx)
    {
        if(idx == 0 || idx == 1)
            return true;

        if(arr[idx] < arr[idx-1])
            return false;
        else if(arr[idx] >= arr[idx-1])
            return isSorted(arr,idx-1);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1,2,7,5,6},4));
    }
}
