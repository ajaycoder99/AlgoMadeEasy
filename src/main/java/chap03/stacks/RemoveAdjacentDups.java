package chap03.stacks;

import java.util.Arrays;
import java.util.Stack;

public class RemoveAdjacentDups {

    public static void removeAdjDups(int[] arr)
    {

    // stores previous valid character
    int prev = arr[0];

    // k maintains the index of last filled location in the result
    int k = 0;

    // start from second character
    int i = 1;

    // do till end of the String is reached
	while (i < arr.length)
    {
        // if the current character is not same as the previous character
        if (prev != arr[i])
        {
            arr[++k] = arr[i++];	// update result
            prev = arr[k];			// update prev
        }
        else
        {
            // remove adjacent duplicates
            while (i < arr.length && prev == arr[i]) {
                i++;
            }

            prev = arr[--k];		// update prev
        }
    }

    // delete str[k+1, n) as result lies in str[0..k]
        i=0;
		while (i < k)
        {
            System.out.print(" " + arr[i]);
            i++;
        }
	}

    public static void main(String[] args) {
        //removeAdjDups(new int[]{1,5,6,8,8,8,0,1,1,0,6,5});
        removeAdjDups(new int[]{1,2,3,3,3,1});
    }
}


