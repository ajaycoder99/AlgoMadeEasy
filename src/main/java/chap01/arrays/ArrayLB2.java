package chap01.arrays;

import java.util.*;

public class ArrayLB2 {

    static int[] arr = {7,3,4,3,5,6,5,2,7};
    public static void main(String[] args) {
        unionOf2SortedArray();
        System.out.println("Intersection :: " + Arrays.toString(intersection()));
        System.out.println("\n--------------------------------------");

        System.out.println("Rotate Array :: " + Arrays.toString(rotateArrayByKElements(new int[]{1,2,3,4,5,6},2)));
        System.out.println("\n--------------------------------------");

        System.out.println("Missing Number ::" + findMissingNum(new int[]{3,0,1,2,5}));
        System.out.println("\n--------------------------------------");

        findAllPairsWithSum(new int[]{1, 2, 2, 3},3);
        findDups(new int[]{7,3,4,3,5,6,5,2,7});

        System.out.println("Input Array :: " + Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("Quick Sort :: " + Arrays.toString(arr));
        System.out.println("\n--------------------------------------");

        int[] a = {1, 5, 10, 20, 40, 80};
        int[] b = {6, 7, 20, 80, 100};
        int[] c = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println("Find Common of 3 arrays ::");
        findCommon(a,b,c);
        System.out.println();

        System.out.println("First Repeating Number in Array :: " + firstRepeatingNumber(new int[]{1, 5, 3, 4, 3, 5, 6}));
        System.out.println("\n--------------------------------------");

        System.out.println("First Non Repeating Number in Array :: " + firstNonRepeatingNumber(new int[]{-1, 2, -1, 3, 2}));
        System.out.println("\n--------------------------------------");

        findTheLargestThreeElements(new int[]{19, -10, 20, 14, 2, 16, 10});
        System.out.println("\n--------------------------------------");

        rearrangePosNegNumsAlternate(new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8});
        // {1, 2, 3, -4, -1, 4}
        System.out.println("\n--------------------------------------");

        System.out.println("Sub Array with sum equals to zero");
        checkIfSubArrayEqZero(new int[]{8, 4, 2, -3, 1, 6}); // Use only to check if sub array exist with this sum
        System.out.println("\n--------------------------------------");

        subArraySum(new int[]{4, 2, -3, -4, 6},5,1);
        System.out.println("\n--------------------------------------");

        System.out.println("Max Sub Array :: " + maxSumSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        System.out.println("\n--------------------------------------");

        System.out.print("Factorial of 25 a Large Number ");
        factorial(25);
        System.out.println("\n--------------------------------------");

        System.out.printf("Max Product of SubArray :: " + maxProduct(new int[]{ -2, -3, 0, -2, -40},5));
        System.out.println("\n--------------------------------------");

        System.out.printf("Find Longest Consecutive SubSequence :: " + findLongestConseqSubseq(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42},11));
        System.out.println("\n--------------------------------------");

        System.out.println("Find find in rotated and sorted array :: " + findMin(new int[]{5, 6, 1, 2, 3, 4},0,5));
        System.out.println("\n--------------------------------------");

        System.out.println("Find the number of digits need to be changed to make second half anagram of first half :: " + getAnagram("123121"));
        System.out.println("\n--------------------------------------");
    }

    public static void unionOf2SortedArray()
    {
        int[] arr1 = {1,2,3,4,5,5};
        int[] arr2 = {3,5,6,6,6,8,9};
        int m = arr1.length;
        int n = arr2.length;

        // Intersection
        int i=0,j=0;
        System.out.println("Input Arrays ::" + Arrays.toString(arr1) + "   " + Arrays.toString(arr2));
        System.out.print("Union of 2 Arrays :: ");
        while (i < m && j < n) {
            if (arr1[i] < arr2[j])
                System.out.print(arr1[i++] + " ");
            else if (arr2[j] < arr1[i])
                System.out.print(arr2[j++] + " ");
            else {
                System.out.print(arr2[j++] + " "); // when both equal print and increment i and j
                i++;
            }
        }

        /* Print remaining elements of
         the larger array */
        while (i < m)
            System.out.print(arr1[i++] + " ");
        while (j < n)
            System.out.print(arr2[j++] + " ");
        System.out.println("\n--------------------------------------");
    }

    public static int[] intersection() {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        Set<Integer> list = new HashSet<>();
        System.out.println("Input Arrays ::" + Arrays.toString(nums1) + "   " + Arrays.toString(nums2));
        // Intersection
        int i=0,j=0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j])
            {
                list.add(nums1[i]);
                i++;j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else
                j++;
        }
        int[] arr = new int[list.size()];
        i=0;
        for(Integer a : list){
            arr[i++] = a;
        }
        return arr;
    }

    public static int[] rotateArrayByKElements(int[] arr, int k)
    {
        System.out.println("Input Array :: " + Arrays.toString(arr) + " by elements :: " + k);
        reverse(arr,0,arr.length-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,k-1);
        return arr;
    }

    public static void reverse(int[] arr, int start, int end){
        while (start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int findMissingNum(int[] nums){
        System.out.println("Input Array :: " + Arrays.toString(nums));

        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max)
                max = nums[i];
        }
        int[] arr = new int[max == 0 ? 1 : max + 1];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                return i;
            }
        }
        return arr.length;
    }

    // find all pair of Integers whose sum is number
    public static void findAllPairsWithSum(int[] arr, int target){
        System.out.println("Input Array :: " + Arrays.toString(arr) + " target :: " + target);
        System.out.println("Find All Pairs :: ");
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length ; i++)
        {
            if(set.contains(target-arr[i]))
                System.out.print("["+ arr[i] + "," + (target - arr[i])+"]");
            else
                set.add(arr[i]);
        }

        System.out.println("\n--------------------------------------");
    }

    // elements are between 0 to n // if any elements then use Set
    // Nick White trick
    public static void findDups(int[] arr){
        System.out.println("Input Array :: " + Arrays.toString(arr));
        int index;
        System.out.print("Duplicates :: ");
        for(int i = 0; i < arr.length; i++){
            index = Math.abs(arr[i]) - 1;
            if(arr[index] < 1)
                System.out.print(Math.abs(arr[i]) + " ");
            arr[index] = -arr[index];
        }
        System.out.println("\n--------------------------------------");
    }

    // Quick Sort Array
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    static void findCommon(int ar1[], int ar2[], int ar3[])
    {
        System.out.println("Input Arrays ::" + Arrays.toString(ar1) + "   " + Arrays.toString(ar2) + "   " + Arrays.toString(ar3));
        // Initialize starting indexes for ar1[], ar2[] and ar3[]
        int i = 0, j = 0, k = 0;

        // Iterate through three arrays while all arrays have elements
        while (i < ar1.length && j < ar2.length && k < ar3.length)
        {
            // If x = y and y = z, print any of them and move ahead
            // in all arrays
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k])
            {   System.out.print(ar1[i]+" ");   i++; j++; k++; }

            // x < y
            else if (ar1[i] < ar2[j])
                i++;

                // y < z
            else if (ar2[j] < ar3[k])
                j++;

                // We reach here when x > y and z < y, i.e., z is smallest
            else
                k++;
        }
        System.out.println("\n--------------------------------------");
    }

    public static int firstRepeatingNumber(int[] arr){
        System.out.println("Input Array :: " + Arrays.toString(arr));

        for(int i = 0; i<arr.length; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[i] < 1)
                return Math.abs(arr[i]);
            else
                arr[index] = -arr[index];
        }
        return -1;
    }

    public static int firstNonRepeatingNumber(int[] arr){
        System.out.println("Input Array :: " + Arrays.toString(arr));
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }

        for (Map.Entry<Integer, Integer> x : map.entrySet())
            if (x.getValue() == 1)
                return x.getKey();

        return -1;
    }

    public static void findTheLargestThreeElements(int[] arr)
    {
        System.out.println("Input Array :: " + Arrays.toString(arr));
        int first = arr[0];
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for(int i=1; i < arr.length; i++){
            if(arr[i] > first)
                first = arr[i];
            else if(arr[i] > second)
                second = arr[i];
            else if(arr[i] > third)
                third = arr[i];
        }
        System.out.printf("First : %d Second : %d Third : %d " , first, second, third);
    }

    public static void rearrangePosNegNumsAlternate(int[] arr)
    {
        System.out.println("Input Array :: " + Arrays.toString(arr));
        for(int i=0 ; i < arr.length ; i++){
            if(i%2 == 0 && arr[i] > 0){
                findNextAndRotate(arr,i,false);
            }
            else if (i%2 != 0 && arr[i] < 0){
                findNextAndRotate(arr,i,true);
            }
        }
        System.out.println("Alternate Negative & Positive :: " + Arrays.toString(arr));
    }

    public static void findNextAndRotate(int[] arr,int i, boolean isNegative){
        int len = arr.length;
        int j = i+1;
        if(isNegative){
            while (j < len)
            {
                if (arr[j] > 0)
                {
                    swapAndRotate(arr,i,j);
                    break;
                }
                j++;
            }
        }
        else {
            while (j < len)
            {
                if (arr[j] < 0)
                {
                    swapAndRotate(arr,i,j);
                    break;
                }
                j++;
            }
        }
    }

    public static void swapAndRotate(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        int i = start+1;
        while(end > i){
            arr[end] = arr[end-1];
            end--;
        }
        arr[start+1] = temp;
        //{-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
    }

    public static void checkIfSubArrayEqZero(int[] arr)
    {
        System.out.println("Input Array :: " + Arrays.toString(arr)); // 4, 2, -3, 1, 6
        int i = 0;
        int sum = 0;
        HashSet<Integer> map = new HashSet<>();
        while(i < arr.length)
        {
            sum = sum + arr[i];
            if (arr[i] == 0 || sum == 0 || map.contains(sum)) {
                System.out.printf("Found a sub array with 0 sum %d", sum);
                return;
            }
            map.add(sum);
            i++;
        }
        System.out.println("No Such Sub Array Exists!");
    }

    static int subArraySum(int arr[], int n, int sum)
    {
        int curr_sum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum,
            // then return true
            if (curr_sum == sum) {
                int p = i - 1;
                System.out.println(
                        "Sum found between indexes " + start
                                + " and " + p);
                return 1;
            }

            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }

    // Kandane Algorithm Very Important
    public static int maxSumSubArray(int[] arr){
        int max_so_far = 0;
        int max_ending_here = 0;
        int i = 0;
        while(i<arr.length){
            max_ending_here = max_ending_here + arr[i];

            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;

            if(max_ending_here < 0)
                max_ending_here = 0;

            i++;
        }
        return max_so_far;
    }

    static void factorial(int n)
    {
        int res[] = new int[500];

        // Initialize result
        res[0] = 1;
        int res_size = 1;

        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        System.out.println("Factorial of given number is ");
        for (int i = res_size - 1; i >= 0; i--)
            System.out.print(res[i]);
    }

    // This function multiplies x with the number
    // represented by res[]. res_size is size of res[] or
    // number of digits in the number represented by res[].
    // This function uses simple school mathematics for
    // multiplication. This function may value of res_size
    // and returns the new value of res_size
    static int multiply(int x, int res[], int res_size)
    {
        int carry = 0; // Initialize carry

        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < res_size; i++)
        {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
            // 'prod' in res[]
            carry = prod/10; // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry!=0)
        {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

    // Function to find maximum product subarray
    static int maxProduct(int arr[], int n)
    {

        // Variables to store maximum and minimum
        // product till ith index.
        int minVal = arr[0];
        int maxVal = arr[0];

        int maxProduct = arr[0];

        for (int i = 1; i < n; i++)
        {

            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal.
            if (arr[i] < 0)
            {
                int temp = maxVal;
                maxVal = minVal;
                minVal =temp;

            }

            // maxVal and minVal stores the
            // product of subarray ending at arr[i].
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxVal);
        }

        // Return maximum product found in array.
        return maxProduct;
    }

    // Returns length of the longest
    // consecutive subsequence
    static int findLongestConseqSubseq(int arr[], int n) // 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1)) {
                // Then check for next elements
                // in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

    // Find min in rotated and sorted array
    static int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array
        // is not rotated at all
        if (high < low)  return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }

    // https://www.geeksforgeeks.org/minimum-number-of-manipulations-required-to-make-two-strings-anagram-without-deletion-of-character/
    public static int getAnagram(String s) {
        int count=0;
        if(s.length() == 1)
            return 0;

        char[] charArray = s.toCharArray();
        if(s.length() == 2)
            if(charArray[0] == charArray[1])
                return 0;
            else
                return 1;

        int charCount[] = new int[10];
        for(int i = 0 ; i < s.length()/2 ; i++){
            charCount[s.charAt(i) - '0']++;
        }

        for(int i = s.length()/2 ; i < s.length() ; i++){
            charCount[s.charAt(i) - '0']--;
        }

        for(int i = 0 ; i < 10; i++){
            if(charCount[i] < 0)
                count = count + Math.abs(charCount[i]);
        }

        return count;
    }
}
