package maths;

public class Ways2Sum {

    public static int ways(int total, int k) {
        int countArr[] = new int[total + 1];

        countArr[0] = 1;

        int numsArr[] = new int[k];
        int x = 1;
        for (int i = 0; i < numsArr.length; i++)
            numsArr[i] = x++;

        for (int i = 1; i <= total; i++)
            for (int j = 0; j < numsArr.length; j++)
                if (i >= numsArr[j])
                    countArr[i] += countArr[i - numsArr[j]];

        return countArr[total];
    }

    public static void main(String[] args) {
        System.out.println(ways(4, 2));
        System.out.println(countWays(3));
    }

    static int countWays(int N) {

        int count[] = new int[N + 1];
        int arr[] = {1,2};

        // base case

        count[0] = 1;


        // count ways for all values up

        // to 'N' and store the result

        for (int i = 1; i <= N; i++)
            for (int j = 0; j < arr.length; j++)
                if (i >= arr[j])
                    count[i] += count[i - arr[j]];

        return count[N];


    }

};


// method to count the total number

// of ways to sum up to 'N'


