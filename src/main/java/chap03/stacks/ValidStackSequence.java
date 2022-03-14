package chap03.stacks;

public class ValidStackSequence {

    public static boolean checkIfValidStack(int arr[] , int arr1[])
    {
        IntegerStack stack = new IntegerStack();

        int j = 0;

        for (int i = 0 ; i < arr.length ; i++ )
        {
            stack.push(arr[i]);

            while (!stack.isEmpty() && j < arr1.length && stack.top() == arr1[j])
            {
                stack.pop();
                j++;
            }
        }
        return arr.length == j;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int arr1[] = { 4, 5, 3, 2, 1 };
        System.out.println(checkIfValidStack(arr,arr1));
    }
}
